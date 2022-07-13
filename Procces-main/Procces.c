/**
 Lo que se requiere es programar  3 procesos automáticamente.
 Por ejemplo  que se ejecute automáticamente el navegador 8:30 am,
 el  BlueJ 3 pm,  el reproductor de música,  la alarma o lo que ustedes
  gusten programar e  indicar a que horas se debe ejecutar su proceso.
*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>

char* getLocal(){
time_t tiempo = time(NULL);
   struct tm *tlocal = localtime(&tiempo);
   char output[128];
   strftime(output,128,"%H:%M:%S",tlocal);
   char* t= ("%s",output);
   return t;
}

void CreaProceso(char proceso[10]){
    char command[50];
    strcpy( command, proceso );
    system(command);
   }


  int cola = 3; // UNica variable global
int main () {
   char  horabluej     [14];
   char  horafirefox   [14];
   char  horasolitario [14];
   printf(" --------------------------------------------------------------- \n");
   printf(" | El formato de la hora debe llevar la siguinete nomenclatura | \n");
   printf(" |     Utiliza el formato de 24 h, ejemplo 13:05:15            | \n");
   printf(" --------------------------------------------------------------- \n");


   printf("\n Introduzca la hora para lanzar Blue j \n"   );
   scanf ("%s",horabluej);
   printf("------------------------------------------- \n");
   printf(" Introduzca la hora para lanzar Firefox     \n");
   scanf ("%s",horafirefox);
   printf("------------------------------------------- \n");
   printf(" Introduzca la hora para lanzar Sudoku   \n");
   scanf ("%s",horasolitario);
   printf("*************** ESPERANDO ***************** \n");

    while(cola != 0)
    Shedeluder(horabluej,horafirefox,horasolitario);


      printf("\n *************** TERMINADO ***************** ");

   return 0;
}

void Shedeluder(char  a[15],char b [15],char c [15] ){
    char* t= getLocal();


  do {


   if(strcmp(t,a) == 0 ){
      CreaProceso("bluej &");
      sleep(1);
      cola --;
      break;
    }
   if(strcmp(t,b) == 0){
        CreaProceso("firefox &");
        sleep(1);
        cola --;
        break;

      }

    if(strcmp(t,c) == 0){
        CreaProceso("gnome-sudoku &");
        sleep(1);
        cola --;
        break;

    }

     t= getLocal();

    }while(t > 0);

}
