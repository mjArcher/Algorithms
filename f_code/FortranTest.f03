program HelloWorld
  write (*,*) 'Hello, world!'   ! This is an inline comment
end program HelloWorld

open(2,file=filenm(i),status='unknown')
do j=1,num_lines
  do k=1,dime
    read(2,*) z(k)
  enddo
  if( j .ge. 1000 ) then
    do k=1,dime
      sumz(k)=sumz(k)+z(k)
    enddo
    nsteps=nsteps+1.0
  endif
enddo
close(2)
