package org.example;


import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{

    /*
    Bài 1: Hãy viết method nhận vào một số nguyên n, tính tổng tất cả các số chẵn nhỏ hơn n.
    Viết test method cho method vừa viết.
     */
    public int sumEvenNumber(int number){
      int i = 0;
      int sum = 0;
      int reSum = 0;
      while ( i < number && reSum < number)
      {
          if (i % 2 == 0)
          {
              reSum += i;
              if (reSum <= number)
                  sum = reSum;
          }
          i += 1;
      }
      return sum;
    }

    @Test
    public void checkTrue_sumEvenNumber(){

        //Arrange
        int inputNumber = 15;

        //Action
        int actualTotal = sumEvenNumber(inputNumber);
        System.out.println(actualTotal);

        //Assert
        Assert.assertTrue(actualTotal < inputNumber);
    }

    @Test
    public void checkFalse_sumEvenNumber(){

        //Arrange
        int inputNumber = 15;

        //Action
        int actualTotal = sumEvenNumber(inputNumber);
        System.out.println(actualTotal);

        //Assert
        Assert.assertFalse(actualTotal > inputNumber);

    }
   /*
     Bài 2: Hãy viết method nhận vào một số nguyên dương n. Hãy viết giải thuật tính n!. n!= n*(n-1)…*1;
     Viết test method cho method vừa viết.
     */

    public int multipleNumber(int number){
        if (number <= 2)
            return number;

        int result = 1;
        for (int i = number; i > 1; i--)
            result *= i;

        return result;

    }

    @Test
    public void check_multipleNumber(){
        //Arrange
        int inputNumber = 7;
        int expectedValue = 5040;

        //Action
        int actualValue = multipleNumber(inputNumber);
        System.out.println(actualValue);

        //Assert
        Assert.assertTrue(expectedValue==actualValue );

    }

    /*
    Bài 3: Hãy viết method nhận vào một số nguyên n và kiểm tra xem số n này có phải là số nguyên tố hay không?
    Viết test method cho method vừa viết.
     */
    public boolean isPrimeNumber(int number){
        if (number < 2)
            return false;
        if(number == 2)
            return true;
        if (number < 10 && number%2!=0)
            return true;
        if (number%2==0 || number%3==0 || number%5==0 || number%7==0 || number%9==0 )
            return false;
        return true;
    }

    @Test
    public void check_isPrimeNumber(){
        //Arrange - given
        int number = 1031;

        //Action
        boolean isResult = this.isPrimeNumber(number);
        System.out.println(number);

        //Assert
        Assert.assertTrue(isResult);
    }

    /*
    Bài 4: Hãy viết method nhận vào 2 số nguyên, hãy viết giải thuật đưa ra ước chung lớn nhất của 2 số này.
           Viết test method cho method vừa viết.
     */

    public int findUSCLN(int number1, int number2){
        int result = 1;

        if(number1%number2==0)
            result=number2;
        else if(number2%number1==0)
            result=number1;
        else {
            boolean isPrimeNumber1 = isPrimeNumber(number1);
            boolean isPrimeNumber2 = isPrimeNumber(number2);
            if (isPrimeNumber1 || isPrimeNumber2)
                result = 1;
            else {
                int iloop = Math.min(number1, number2);
                for (int i = 1; i <= iloop; i++) {
                    if (number1 % i == 0 && number2 % i == 0)
                        result = i;
                }
            }
        }

        return result;
    }

    @Test
    public void check_findUSCLN(){

        //Arrange - Given
        int number1 = 125;
        int number2 = 110;

        //Action
        int result = findUSCLN(number1, number2);

        //Assert
        System.out.println(result);
    }

    /*
    Bài 5: Hãy viết method nhận vào một số nguyên dương n.
    Hãy viết giải thuật tìm các cặp số có tổng = n. Viết test method cho method vừa viết.
     */
    public String findSumAsInput(int n)
    {
        String result = "";

        if (n <= 0)
         result = "n <= 0";
        else
        {
            int i = 1;
            int j = n-1;
            String pairNumber = "";
            while (i<=j)
            {
                if (n==i+j) {
                    pairNumber = String.format("(%d,%d)\n", i, j);
                    result = result.concat(pairNumber);
                }
                j--;
                i++;
            }
        }
        return result;

    }

    @Test
    public void check_findSumAsInput(){

        //Arrange
        int n = 23;
     //   String expected = "(1,9)(2,8)(3,7)(4,6)(5,5)"; --n=10

        //Action
        String actual = findSumAsInput(n);

        System.out.println(actual);

        //Assert
    //    Assert.assertEquals(expected, actual);

    }

    /*
    Bài 6: Hãy viết giải thuật sử dụng method ở bài 3.
    Liệt kê tất cả cá số nguyên tố <100.
     */

    @Test
    public void check_isPrimerBaseNumber()
    {
        int n = 100;
        String expected = "";

        //Action
        for (int i=3; i<=n;i++)
        {
            if (isPrimeNumber(i))
                expected = expected.concat(String.format("%d\n", i));
        }
        System.out.println(expected);

    }

    /*
    Bài 7: Hãy viết method nhận vào số nguyên dương n.
    Hãy sử dụng method ở bài 3 viết method liệt kê n số nguyên tố đầu tiên.
     */

    @Test
    public void listFisrtPrimers()
    {
        int i=1;
        int j=1;
        int n = 10;
        String list = "";
        while (i<=n)
        {
            if (isPrimeNumber(j)) {
                list = list.concat(String.format("%d\n",j));
                i++;
            }
            j++;
        }
        System.out.println(list);
    }



}
