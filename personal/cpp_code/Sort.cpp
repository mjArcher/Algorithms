#include <iostream>
#include <fstream>
#include <cmath>
#include <time.h>
#include <vector>
#include <stdlib.h> //fort the rand function

using namespace std;

#include "Sort.h"


//print the list of numbers (template this function)
//remember to pass by reference
void printList(vector<int> &numbers){
   cout << endl;
   vector<int>::iterator numbersIterator;

   for(numbersIterator = numbers.begin(); numbersIterator != numbers.end(); numbersIterator++)
   {
      cout << *numbersIterator << " ";
   }
}

   template <class T> 
void Show2(vector<T> &myvec)
{
   typename vector<T>::iterator it;
   cout << "Vector contains:";
   for( it = myvec.begin(); it < myvec.end(); it++)
   {
      cout << " " << *it;
   }
   cout << endl;

}
//sort a random array of numbers using insertion sort
void insertionSort(){
   //using loops
   vector<int>	numbers(10);
   for (int i = 0; i < 10; i++ ){
      numbers[i] = rand() % 100;
   }	

   for (int i = 0; i < numbers.size(); i++){
      cout << numbers[i] << endl;	
   }

   //Now time to sort
   //
   // j indicates the current card 
   // subtract one from the index operations in cormen
   int key, index;
   for(int j = 1; j < numbers.size(); j++)
   {
      key = numbers[j];	
      //insert A[j] into the sorted sequence 
      index = j - 1;	
      while (index > -1 && numbers[index] > key){
         numbers[index + 1] = numbers[index];
         index--;
      }
      numbers[index + 1] = key;
   }

   printList(numbers);
}
//remove need for sentinel check


// make sure that indices are correct: Cormen indexes arrays from 1 to N
// C++ index convention is from 0 to N-1
// say length(A) = 8 
// L and R here are sorted vectors of integers
void merge(vector<int> &A, int p, int q, int r){
   //simple merge algorithm from cormen pg. 29
   int n1 = q - p + 1;	//3 - 0 + 1 = 4
   int n2 = r - q; //7 - 3 = 4
   //create arrays L and R
   vector<int> L(n1), R(n2);
   cout << "size " << L.size() << endl;
   int i = 0;
   for (i; i < n1; i++)
      L[i] = A[p + i];
   int j = 0;
   for (j; j < n2; j++)
      R[j] = A[q + 1 + j];

   //put a condition here:
   int k = p;
   int u = 0, v = 0;
   for (k; k < r + 1; k++){
      if(L[u] <= R[v]){
         A[k] = L[u];
         u++;
      }	
      else {
         A[k] = R[v];	
         v++;
      }
      if(u == n1 || v == n2) // n additional checks here 
         break; //break here with u and v incremented to next positions 
   }
   k++;
   if(u < v)
      for(int l = u; l < n1; l++){
         A[k] = L[u];
         k++;
      }
   else
      for(int l = v; l < n2; l++){
         A[k] = R[v];
         k++;
      }
   //check which one is less and assign to k
   /* for(k; k < 10; k++) */
   /* 	cout << k; */
   /* //careful because k increments to 10; */
   /* cout << k; */

   /* for */

}

//divide and conquer
//1. divide: 
//2. conquer
//3. combine
void mergeSort(vector<int> &A, int p, int r){
   //recursive call
   int q;
   if(p < r){
      q = (p + r)/2;	
      cout << "q " << q << endl;
      mergeSort(A, p, q);	
      mergeSort(A, q + 1, r);
      merge(A, p, q, r); //0, 3, 7. if A.size() = 8
   }
}

int main(int argc, char **argv){

   cout << "Hello world!! in source code pro" << endl;
   insertionSort();
   vector<int> numbers(10);
   //perform merge-sort 	
   //check rounding	
   int i = 7.9999999;
   cout << i << endl;

   static const int arr[] = {5, 2, 4, 7, 1, 3, 2, 6};

   /* static const int arr[] = {1, 3, 4, 7, 2, 5, 6, 8}; */
   vector<int> A(arr, arr + sizeof(arr) / sizeof(arr[0]) );
   cout << sizeof(arr[0]) << " bytes " << sizeof(arr) << " bytes total array " << endl;
   for(int i = 0; i < A.size(); i++)
      cout << A[i] << endl;
   //perform merge sort
   //
   mergeSort(A, 0, 7);
   cout << "Sorted array " << endl;	
   /* merge(A, 0, 3, 7); */

   for(int i = 0; i < A.size(); i++)
      cout << A[i] << endl;
}

//TO REVIEW: (LANGUAGES) - FORTRAN AND C++
//ITERATORS, DONE
//TEMPLATES
//CLASSES, INHERITANCE AND DYNAMIC CASTING/POLYMORPHIC TYPES

//ALGORITHMS:
//SORTING, MERGE, INSERTION
//EVOLUTIONARY ALGORITHMS, LINEAR PROGRAMMING, 
//COOTES ET AL 
