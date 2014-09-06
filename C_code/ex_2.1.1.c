#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <sys/time.h>

#ifdef __cplusplus
extern "C" void dgemm_(const char *, const char *, int *, int *, int *,
    double *, double *, int *, double *, int *,double *, double *, int *);
#else
extern void dgemm_(const char *, const char *, int *, int *, int *,
    double *, double *, int *, double *, int *,double *, double *, int *);
#endif


void fail (const char *message) {
    printf("%s\n",message);
    exit(EXIT_FAILURE);
}


void check (const double *matrix, int size) {
/* Print the trace of a square matrix and the other corner elements. */
    double x = 0.0;
    int n;

    for (n = 0; n < size; ++n) x += matrix[n+n*size];
    printf("Checking values = %.3f, %.3f, %.3f\n",
        x,matrix[(size-1)+0*size],matrix[0+(size-1)*size]);
}


void times (const char *which) {
/* If which is not empty, print the times since the previous call. */
    static double last_wall = 0.0, last_cpu = 0.0;
    double wall, cpu;
    struct timeval tv;
    clock_t stamp;

    wall = last_wall;
    cpu = last_cpu;
    if (gettimeofday(&tv,NULL) != 0 ||
            (stamp = clock()) == (clock_t)-1)
        fail("Unable to get times");
    last_wall = tv.tv_sec+1.0e-6*tv.tv_usec;
    last_cpu = stamp/(double)CLOCKS_PER_SEC;
    if (strlen(which) > 0) {
        wall = last_wall-wall;
        cpu = last_cpu-cpu;
        printf("%s time = %.2f seconds, CPU = %.2f seconds\n",which,wall,cpu);
    }
}


void multiply (const double *left, const double *right, double *out,
        int size) {
/* Matrix multiply:  out = left*right */
   double x;
   int i, j, k;

/* Note that most of the the clauses aren't needed here, because the
default rules do what is wanted.  The private(j,k,x) is. */
#pragma omp parallel for default(none), shared(out,left,right,size), \
        private(i,j,k,x)
    for (i = 0; i < size; ++i)
        for (j = 0; j < size; ++j) {
            x = 0.0;
            for (k = 0; k < size; ++k)
                x += left[i+k*size]*right[k+j*size];
            out[i+j*size] = x;
        }
}


int main (int argc, char *argv[]) {
    double *input, *output, one = 1.0, zero = 0.0;
    int size;
    FILE *f;

/* Read the file name from the argument and set up the data. */
    if (argc != 2) fail("Wrong number of arguments");
    if ((f = fopen(argv[1],"rb")) == NULL)
        fail("Unable to open input file");
    if (fread(&size,sizeof(int),1,f) != 1 || size < 1 || size > 1000000)
        fail("Invalid value of size");
    if ((input = (double *)malloc(size*size*sizeof(double))) == NULL ||
            (output = (double *)malloc(size*size*sizeof(double))) == NULL)
        fail("Unable to allocate space");
    if ((int)fread(input,sizeof(double),size*size,f) != size*size ||
            ferror(f) || fclose(f))
        fail("Unable to read data");
    check(input,size);

/* Time and check the use of DGEMM. */
    times("");
    dgemm_("n","n",&size,&size,&size,&one,input,&size,input,&size,
       &zero,output,&size);
    times("DGEMM");
    check(output,size);

/* Time and check the use of hand-coded multiply. */
    times("");
    multiply(input,input,output,size);
    times("Coded");
    check(output,size);

    return 0;
}
