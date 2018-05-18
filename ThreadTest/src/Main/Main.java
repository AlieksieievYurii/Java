package Main;

import java.util.Scanner;

public class Main
{
    private static Algorytm algorytm = new Algorytm();
    private static Thread potocOne = new Thread(algorytm);
    private static boolean _autorelive = false;

    public static void main(String[] args)
    {
	    potocOne.start();
	    StartMenu();
    }

    private static void StartMenu()
    {
        Scanner scn = new Scanner(System.in);
        String mode;

        boolean programRun = true;

        System.out.println("[?] For help enter /help...");

        while(programRun)
        {
            autoRelive();
            System.out.print("\n[*] Mode:>");
            mode = scn.next();

            switch (mode.toLowerCase())
            {
                case "/help":
                            System.out.println("/check -- check Thread");
                            System.out.println("/set <integer> -- set number for processing");
                            System.out.println("/stop -- stop processing");
                            System.out.println("/relive -- relive Thread");
                            System.out.println("/autorelive -- autorelive Thread");
                            System.out.println("/printprocess -- show 5 elemets of  Thread");
                            System.out.println("/exit -- exit program");
                            break;
                case "/printprocess":
                            algorytm.PrintProcesFive();
                            break;
                case "/set":
                            if(!potocOne.isAlive())
                            {
                                System.out.println("[!] Thread is dead! Pleas relive thread!");
                                break;
                            }

                            String number = scn.next();
                            algorytm.setNumber(number);
                            System.out.println("[@] Number "+number+" is setuped!");
                            delayThread(100);
                            break;

                case "/stop":
                            algorytm.stopProcess();
                            break;
                case "/check":
                            System.out.println("[*] Thread is "+potocOne.isAlive());
                            break;
                case "/autorelive":
                            _autorelive = true;
                            System.out.println("[*] Autorelive is ON!");
                            break;
                case "/exit":
                            System.out.println("-------------------------\n[*] Program is finished!");
                            programRun = false;
                            System.exit(0);
                            break;
                case "/relive":
                                reliveThread();
                                break;
                 default:
                        System.out.println("[!] Command is unknown!");
                        break;
            }
        }
    }

    private static void autoRelive()
    {
        if(_autorelive)
        {
            if(!potocOne.isAlive())
            {
                reliveThread();
            }
        }
    }

    private static void reliveThread()
    {
        if(potocOne.isAlive())
        {
            System.out.println("[!] Thread is still alive!");
            return;
        }
        else {
            algorytm.setNumber("");
            potocOne = new Thread(algorytm);
            potocOne.start();
            System.out.println("[*] Thread is again relive!");
        }

    }

    private static void delayThread(int number)
    {
        try
        {
            potocOne.sleep(number);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
