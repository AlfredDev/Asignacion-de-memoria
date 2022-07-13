#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>
char* getLocal(){
time_t tiempo = time(0);
   struct tm *tlocal = localtime(&tiempo);
   char output[128];
   strftime(output,128,"%H:%M:%S",tlocal);
   char* t= (output);
   return t;
}

int main () {
   int   cola = 3;
   char  horabluej     [15];
   char  horafirefox   [15];
   char  horasolitario [15];
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
   printf(" Introduzca la hora para lanzar Solitario   \n");
   scanf ("%s",horasolitario);
   printf("*************** ESPERANDO ***************** \n");

   do {
char* t= getLocal();


   if(strcmp(t,horabluej) == 0){
      printf("%s%d%s","\n Se lanzo el proceso Bluej resta: ",cola ," Procesos");
      horabluej [15] = "null";
      //CreaProceso("oclock &");
      cola --;
  }
     if(strcmp(t,horafirefox) == 0){
        horafirefox [15] = "null";
        printf("%s%d%s","\n Se lanzo el proceso Firefox resta: ",cola ," Procesos");
       // CreaProceso("sol &");
        cola --;
      }
        if(strcmp(t,horasolitario) == 0){
         //CreaProceso("top &");
         printf("%s%d%s","\n Se lanzo el proceso Solitario resta: ",cola ," Procesos");
         horasolitario [15] = "null";
         cola --;
         }

}while(cola != 0);

      printf("\n *************** TERMINADO ***************** ");

   return 0;
}


void CreaProceso(char proceso[10]){
    char command[50];
    strcpy( command, proceso );
    system(command);
   }




