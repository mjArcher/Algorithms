# Matt Archer. Simple Makefile Jan 2014
# Can use $(shell ...) which expands to the output of the argument(s))

CUDA:=
CPPFLAGS=-g -Wall# $(shell root-config --cflags)
LDFLAGS=-g #$(shell root-config --ldflags)
LDLIBS=#$(shell root-config --libs)

SRCS=Sort.cpp Test.cpp
OBJS=$(subst .cpp,.o,$(SRCS))#substitutes all .cpp in SRCS variable with .o (objects)

Test: $(OBJS)
    g++ $(LDFLAGS) -o Test Test.o Sort.o $(LDLIBS) 

Test.o: Test.cpp Test.h Sort.h
    g++ $(CPPFLAGS) -c Test.cpp

Sort.o: Sort.cpp Sort.h
    g++ $(CPPFLAGS) -c Sort.cpp 
