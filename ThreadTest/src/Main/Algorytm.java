package Main;

public class Algorytm implements Runnable
{
    private String number = "";
    private int numberForProcess = 0;
    private boolean isRunning = true;

    private boolean printFlag = false;

    @Override
    public void run()
    {
        int k = 5;
        while(isRunning)
        {
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){e.printStackTrace();}

            numberForProcess *= 2;
            if(numberForProcess != 0) numberForProcess /= 2;

            if(printFlag && k != 0)
            {
                System.out.println("...."+numberForProcess);
                k--;
            }else
            {
                k = 5;
                printFlag = false;
            }

            if(!number.equals(""))
            {
                numberForProcess = Integer.parseInt(number);
                System.out.println("[*] Process has number "+number+" loading!");
                number = "";
            }
        }
    }
    public void setNumber(String number)
    {
        this.number = number;
    }

    public void stopProcess()
    {
        this.isRunning = false;
        System.out.println("[*] Process is stoped!");
    }

    public void PrintProcesFive()
    {
        printFlag = true;
    }
}
