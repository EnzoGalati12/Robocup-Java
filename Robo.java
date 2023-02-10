
import java.util.Random;
import java.util.Scanner;

public class Robo {

    public static void main(String[] args) {


        Scanner tec = new Scanner(System.in);
        Random random = new Random();

        int participantes, i, j, numrand1, numrand2, aux1, aux2, aux3;

        participantes = 0;
        i = 0;
        j = 0;
        numrand1 = 0;
        numrand2 = 0;

        System.out.println("informe o número total de equipes participantes do torneio: ");
        participantes = tec.nextInt();

        int idequipe[] = new int[participantes];
        int pontuacao[] = new int[participantes];
        int vitorias[] = new int[participantes];
        int notadesign[] = new int[participantes];
        int pontosfinal[] = new int[3];
        int pont[] = new int[3];

        for(i = 0; i < participantes; i++) {

            System.out.println("informe o id da " + (i+1) + " equipe: ");
            idequipe[i]= tec.nextInt();

            while (idequipe[i] < 11 || idequipe[i] > 99) {
                System.out.println("id inválido! digite novamente!");
                System.out.println("informe o id da " + (i+1) + " equipe: ");
                idequipe[i]= tec.nextInt();
            }

            System.out.println("informe a nota de design do robo: ");
            notadesign[i] = tec.nextInt();

            while (notadesign[i] < 0 || notadesign[i] > 10) {
                System.out.println("nota de design inválida! digite novamente!");
                System.out.println("informe a nota de design da " + (i+1) + " equipe: ");
                notadesign[i]= tec.nextInt();
            }
        }

        System.out.println("---PRIMEIRA RODADA DE COMBATES---");
        System.out.println("");
        for (i = 0; i < participantes; i++) {

            for (j = i+1; j < participantes; j++) {

                numrand2 = random.nextInt(10);
                pontuacao [j] = numrand2;

                if(j>i) {
                    numrand1 = random.nextInt(10);
                    pontuacao[i] = numrand1;
                }

                if(pontuacao[i]>pontuacao[j]) {
                    vitorias[i]++;
                }else if(pontuacao[i]<pontuacao[j])  {
                    vitorias[j]++;
                }else if((pontuacao[i] == pontuacao[j]) && (notadesign[i] > notadesign[j])) {
                    vitorias[i]++;
                }else {
                    vitorias[j]++;
                }


                System.out.println("combate |   " + idequipe[i]+" x "+idequipe[j]+"  pontuação:  "+pontuacao[i]+" x "+pontuacao[j]);
            }
        }



        //ORGANIZANDO OS VETORES POR PONTUA  O
        for(int w =0;w<participantes;w++) {
            for(int c =0;c<participantes-1;c++) {
                if(vitorias[c]<vitorias[c+1]) {
                    aux1= vitorias[c];
                    vitorias[c]= vitorias[c+1];
                    vitorias[c+1]= aux1;
                    aux2 = idequipe[c];
                    idequipe[c] = idequipe[c+1];
                    idequipe[c+1]=aux2;
                    aux3 = notadesign[c];
                    notadesign[c] = notadesign[c+1];
                    notadesign[c+1] = aux3;
                }
            }
        }
        //AJUSTANDO O RANKING PELA NOTA DE DESIGN
        for(int w =0;w<participantes;w++) {
            for(int c =0;c<participantes-1;c++) {
                if(vitorias[c]==vitorias[c+1] && notadesign[c]<notadesign[c+1]) {
                    aux1= vitorias[c];
                    vitorias[c]= vitorias[c+1];
                    vitorias[c+1]= aux1;
                    aux2 = idequipe[c];
                    idequipe[c] = idequipe[c+1];
                    idequipe[c+1]=aux2;
                    aux3 = notadesign[c];
                    notadesign[c] = notadesign[c+1];
                    notadesign[c+1] = aux3;
                }
            }
        }
        //MOSTRANDO AS TRES MELHORES EQUIPES
        System.out.println("");
        System.out.println("---3 MELHORES EQUIPES---");
        System.out.println("");
        for(i = 0; i <3; i++) {
            System.out.println("id: " + idequipe[i]+"\t vitorias: " + vitorias[i]);
        }

        System.out.println("");
        System.out.println("---RODADA FINAL---");
        System.out.println("");
        //RODADA FINAL
        for (i = 0; i < 3; i++) {
            for (j = i+1; j <3; j++) {
                numrand2 = random.nextInt(10);
                pontosfinal [j] = numrand2;

                if(j>i) {
                    numrand1 = random.nextInt(10);
                    pontosfinal[i] = numrand1;
                }

                if(pontosfinal[i]>pontosfinal[j]) {
                    pont[i]+=2;
                }else if(pontosfinal[i]<pontosfinal[j])  {
                    pont[j]+=2;
                }else if((pontosfinal[i] == pontosfinal[j]) && (notadesign[i] > notadesign[j])) {
                    pont[i]++;
                }else {
                    pont[j]++;
                }


                System.out.println("combate |   " + idequipe[i]+" x "+idequipe[j]+"  pontuação:  "+pontosfinal[i]+" x "+pontosfinal[j]);

            }
        }

        //ORGANIZANDO OS VETORES POR PONTUA  O
        for(int w =0;w<3;w++) {
            for(int c =0;c<3-1;c++) {
                if(pont[c]<pont[c+1]) {
                    aux1= pont[c];
                    pont[c]= pont[c+1];
                    pont[c+1]= aux1;
                    aux2 = idequipe[c];
                    idequipe[c] = idequipe[c+1];
                    idequipe[c+1]=aux2;
                    aux3 = notadesign[c];
                    notadesign[c] = notadesign[c+1];
                    notadesign[c+1] = aux3;
                }
            }
        }

        //AJUSTANDO O RANKING PELA NOTA DE DESIGN
        for(int w =0;w<3;w++) {
            for(int c =0;c<3-1;c++) {
                if(pont[c]==pont[c+1] && notadesign[c]<notadesign[c+1]) {
                    aux1= pont[c];
                    pont[c]= pont[c+1];
                    pont[c+1]= aux1;
                    aux2 = idequipe[c];
                    idequipe[c] = idequipe[c+1];
                    idequipe[c+1]=aux2;
                    aux3 = notadesign[c];
                    notadesign[c] = notadesign[c+1];
                    notadesign[c+1] = aux3;
                }
            }
        }

        //MOSTRANDO A EQUIPE VENCEDORA
        System.out.println("");
        System.out.println("---EQUIPE VENCEDORA---");

        for(i = 0; i <1; i++) {
            System.out.println("id: " + idequipe[i]);
        }



    }

}

