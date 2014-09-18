    IMPLICIT NONE
    INTEGER, PARAMETER :: dp = SELECTED_REAL_KIND(12)
    REAL(KIND=dp), ALLOCATABLE :: input(:,:), output(:,:)
    INTEGER :: size
    CHARACTER(LEN=100) :: filename

! Read the file name from the argument and set up the data.
    IF (COMMAND_ARGUMENT_COUNT() /= 1) THEN
      WRITE (*,'("Wrong number of arguments")')
      STOP
    END IF
    CALL GET_COMMAND_ARGUMENT(1,filename)
    OPEN (42,FILE=filename,ACTION='READ',FORM='UNFORMATTED')
    READ (42) size
    IF (size < 1 .OR. size > 1000000) THEN
        WRITE (*,'("Invalid value of size: ",I0)') size
        STOP
    END IF
    ALLOCATE(input(size,size),output(size,size))
    READ (42) input
    CLOSE(42)
    CALL Check(input)

! Time and check the use of Fortran's intrinsics.
    CALL Times('')
    output = MATMUL(input,input)
    CALL Times('MATMUL')
    CALL Check(output)

! Time and check the use of DGEMM.
    CALL Times('')
    CALL DGEMM('n','n',size,size,size,1.0_dp,input,size,input,size, &
        0.0_dp,output,size)
    CALL Times('DGEMM')
    CALL Check(output)

! Time and check the use of hand-coded multiply.
    CALL Times('')
    CALL multiply(input,input,output)
    CALL Times('Coded')
    CALL Check(output)

CONTAINS

    SUBROUTINE Times (which)
! If which is not empty, print the times since the previous call.
        CHARACTER(LEN=*), INTENT(IN) :: which
        REAL(KIND=dp), SAVE :: last_wall = 0.0_dp, last_cpu = 0.0_dp
        REAL(KIND=dp) :: wall, cpu
        INTEGER :: m, n

        wall = last_wall
        cpu = last_cpu
        CALL SYSTEM_CLOCK(m,n)
        last_wall = m/REAL(n,KIND=dp)
        CALL CPU_TIME(last_cpu)
        IF (LEN(which) > 0) THEN
          wall = last_wall-wall
          cpu = last_cpu-cpu
          WRITE (*,'(A," time = ",F0.2," seconds, CPU = ",F0.2," seconds")') &
            which,wall,cpu
        END IF
    END SUBROUTINE Times

    SUBROUTINE Check (matrix)
! Print the trace of a square matrix and the other corner elements.
        REAL(KIND=dp), INTENT(IN) :: matrix(:,:)
        REAL(KIND=dp) :: trace
        INTEGER :: size, n

        trace = 0.0
        size = UBOUND(matrix,1)
        DO n = 1,size
        trace = trace+matrix(n,n)
        END DO
        WRITE (*,'("Checking values = ",F0.3,2(", ",F0.3))') &
          trace, matrix(1,size), matrix(size,1)
    END SUBROUTINE Check

    SUBROUTINE Multiply (left, right, out)
! Matrix multiply:  out = left*right
        REAL(KIND=dp), INTENT(IN) :: left(:,:), right(:,:)
        REAL(KIND=dp), INTENT(OUT) :: out(:,:)
        INTEGER :: i, j

! Note that the clauses aren't needed here, because the default rules
! do what is wanted.
!$OMP PARALLEL DO DEFAULT(NONE), SHARED(out,left,right), PRIVATE(i,j)
        DO i = 1,UBOUND(left,1)
          DO j = 1,UBOUND(right,2)
            out(i,j) = DOT_PRODUCT(left(i,:),right(:,j))
          END DO
        END DO
!$OMP END PARALLEL DO
    END SUBROUTINE Multiply

END PROGRAM Main
