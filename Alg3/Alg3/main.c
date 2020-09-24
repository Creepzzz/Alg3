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