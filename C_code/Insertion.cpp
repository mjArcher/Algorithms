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


int main(int argc, char **argv){

	cout << "Hello world!! in source code pro" << endl;
	insertionSort();

}

//TO REVIEW: (LANGUAGES) - FORTRAN AND C++
//ITERATORS, DONE
//TEMPLATES
//CLASSES, INHERITANCE AND DYNAMIC CASTING/POLYMORPHIC TYPES

//ALGORITHMS:
//SORTING, MERGE, INSERTION
//EVOLUTIONARY ALGORITHMS, LINEAR PROGRAMMING, 
//COOTES ET AL 
