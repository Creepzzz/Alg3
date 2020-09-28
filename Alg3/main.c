//Author: Matilda Qvick 001105-0606
//Generated: 20/9 - 2020
//Last updated: 21/9 - 2020
//Solves: Removes all characters that aren't letters
//        in a text file and replaces them with a space
//        to keep the number of characters the same. 
//How to use: Everything is hardcoded, a file is read
//            and the program writes to a destination
//            file. 

#include<stdio.h>
#include<conio.h>
#include<ctype.h>

int i = 0;

int main(void) {
	FILE* txtFileR = fopen("alg3file.txt", "r");
	FILE* txtFileW = fopen("destAlg3.txt", "w");

	int c;
	

	if (txtFileR == NULL || txtFileW == NULL) {
		printf("File could not open");
		return -1;
	}

	while ((c = fgetc(txtFileR)) != EOF) {
		if (isalpha(c)==0 && c!='\n') {
			c = ' ';
		}
		fputc(c, txtFileW);
		i = i +1;
	}
	fclose(txtFileR);
	fclose(txtFileW);
	printf("%d", i);
}