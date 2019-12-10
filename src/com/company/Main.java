package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String a , b;
        Scanner input = new Scanner(System.in);
        a = input.next();
        b = input.next();
        System.out.println(binaryAdd(a,b));
    }

    static String binaryAdd(String binaryA,String binaryB)
    {
        String answer = new String();
        char carry = '0';
        if (binaryA.length() > binaryB.length())
        {
            StringBuilder builder = new StringBuilder(binaryB);
            // builder.append();
            for (int i = binaryB.length() ; i  < binaryA.length() ; i++)
            {
                //builder.append(0);
                builder.insert(0,0);
            }

            binaryB = builder.toString();

        }
        else if (binaryA.length() < binaryB.length())
        {
            StringBuilder builder = new StringBuilder(binaryA);
            // builder.append();
            for (int i = binaryA.length() ; i  < binaryB.length() ; i++)
            {
                builder.insert(0,0);
            }
            binaryA = builder.toString();
        }

        for (int i = binaryA.length() - 1  ; i >= 0 ; i--)
        {

            //if ((Character.compare(binaryA.charAt(i),'0')) && (Character.compare(binaryB.charAt(i),'0')))
            if ((binaryA.charAt(i) == '0') && (binaryB.charAt(i) == '0'))
            {
                if (carry == '0')
                {
                    answer = answer + 0;
                    carry = '0';
                }
                else if (carry == '1')
                {
                    answer = answer + 1;
                    carry = '0';
                }

            }
            else if (((binaryA.charAt(i) == '0') && (binaryB.charAt(i) == '1')) || ((binaryA.charAt(i) == '1') && (binaryB.charAt(i) == '0')))
            {
                if (carry == '0')
                {
                    answer = answer + 1;
                    carry = '0';
                }
                else if (carry == '1')
                {
                    answer = answer + 0;
                    carry = '1';
                }
            }
            else if (((binaryA.charAt(i) == '1') && (binaryB.charAt(i) == '1')) )
            {
                if (carry == '0')
                {
                    answer = answer + 0;
                    carry = '1';
                }
                else if (carry == '1')
                {
                    answer = answer + 1;
                    carry = '1';
                }
            }
        }
        //System.out.println(carry);
        StringBuilder builder = new StringBuilder(answer);
        builder.append(carry);
        return builder.reverse().toString();
    }


}
