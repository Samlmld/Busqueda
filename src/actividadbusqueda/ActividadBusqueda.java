/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadbusqueda;
import java.util.Scanner;
 

/**
 *
 * @author Samlml
 */
public class ActividadBusqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Scanner leer = new Scanner(System.in);
       boolean salir = false;
       
     
       
     Alumno ArregloDeObjetos [] =new Alumno[7];
      
     int Codigo=0;
     String Nombre=" ";
     int Edad=0;
     int auxiliar=0;
     int leerdos =0;
      
 
       int opcion; //Guardaremos la opcion del usuario
        
       while(!salir){
            System.out.println("\n");
           System.out.println("1. Registrar Alumno");
           System.out.println("2. Mostrar todos los Registros");
           System.out.println("3. Busqueda Secuencial");
           System.out.println("4. Busqueda por Algoritmo Binario");
           System.out.println("5. Salir");
            
           System.out.println("\nEscribe una de las opciones");
           
           opcion = leer.nextInt();
          
            
           switch(opcion){
               case 1:

                  System.out.println("\nHas seleccionado la opcion 1");
                  System.out.println("Ingresa Codigo");
                  Codigo = leer.nextInt();
                  System.out.println("Nombre:");
                  Nombre = leer.next();
                  System.out.println("Edad");
                  Edad = leer.nextInt();
                  ArregloDeObjetos[auxiliar] = new Alumno(Codigo,Nombre,Edad);
                  auxiliar ++;
                                             
                      break;
                    case 2:
                        System.out.println(" ");
                   System.out.println("\nHas seleccionado la opcion 2");
                   
                   for (int i = 0; i <auxiliar ; i++) {
                       System.out.println("Codigo:"+ArregloDeObjetos[i].getCodigo()+" "+"\n" +"Nombre:"+  ArregloDeObjetos[i].getNombre() + " " +" \n"+"Edad:"+ ArregloDeObjetos[i].getEdad()+"\n");
                   }
                        System.out.println("\n");
                   
                   break;
                case 3:
                      
                    
                       System.out.println("\nHas seleccionado la opcion 3");
                       System.out.println("Escribe numero a buscar");
                       leerdos=leer.nextInt();
                       System.out.println("\n");
                       
                    boolean SiEsta=false;
                    for (int i = 0; i < auxiliar; i++) {
                        if (leerdos == ArregloDeObjetos[i].getCodigo()) {
                            System.out.println("Codigo:"+ArregloDeObjetos[i].getCodigo()+" "+"\n"+"Nombre:"+ ArregloDeObjetos[i].getNombre()+" "+"\n"+"Edad:"+ArregloDeObjetos[i].getEdad());
                            SiEsta=true;
                        }
                    }
                    if (!SiEsta) {
                        System.out.println("NO se encontró");
                    }

                   break;
                case 4:
                    
                    /*Falta bandera para validar cuando no este*/
                    SiEsta=false;
                           System.out.println("\nHas seleccionado la opcion 4");   
                   int leertres=0;
                   System.out.println("Codigo a buscar:");
                   leertres=leer.nextInt();
                    
                   Alumno[] Orden = Ordenamiento(ArregloDeObjetos, auxiliar);
                    
                   int mostrar = Binario (Orden, leertres, auxiliar);
      
                    System.out.println("Codigo:" + ArregloDeObjetos[mostrar].getCodigo() +"\n"+"Nombre: "+ ArregloDeObjetos[mostrar].getNombre() +" \n"+"Edad: "+ ArregloDeObjetos[mostrar].getEdad());
                   
                   break;
                
                   case 5:
                    
                      salir=true;
                   break;
              
              
           }
            
       }
        
    }
    
 
     
    public static Alumno[] Ordenamiento(Alumno[] a,int ayuda){   //Inserceccion
    int posi, j;
    int auxliardos;
    Alumno alu;
        for (posi = 1; posi < ayuda; posi++){
              auxliardos = a[posi].getCodigo();
              alu = a[posi];
              j = posi - 1;
              while ((j >= 0) && (auxliardos < a[j].getCodigo())){ 
                a[j + 1] = a[j];
                j--;
              }
              a[j + 1] = alu;
        }
        return a;
    }
    
      public static int Binario(Alumno[] alumno, int numeroBuscado,int a){
    int Centro,Inferior=0,Superior=a-1;
    
       while(Inferior<=Superior){
           Centro=(Superior+Inferior)/2;
            if(alumno[Centro].getCodigo()==numeroBuscado)
                return Centro;
            
            else if(numeroBuscado < alumno[Centro].getCodigo()){
                Superior=Centro-1;
            }else{
                Inferior=Centro+1;
            }
        }
    return -1;
    }

 
    
    
    
    
    
       
    
     
}




        
        
        
        
        
    
    

