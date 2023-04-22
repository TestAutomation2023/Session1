package org.example;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    /*
    Bài 8: Áp dụng method viết ở bài 3.
    Hãy viết giải thuật phân tích một số bất kỳ sang thừa số nguyên tố. Ví dụ: 20 = 5*4. Viết test method cho method vừa viết.
     */

    public List<Integer> analystToPrimer(int n){
        List<Integer> arrSplits = new ArrayList<Integer>();
        if (n <= 0 || isPrimeNumber(n))
            arrSplits.add(n);
        else
        {
            int i=2;
            while (i<=n)
            {
                while (n%i==0)
                {
                    arrSplits.add(i);
                    n /= i;
                }
                i = ((n % i) != 0) ? (i + 1) : i;
            }
        }
        return arrSplits;

    }

    @Test
    public void check_analystToPrimer(){

        // Arrange
        int n = 2070;
        List<Integer> lstExpected = Arrays.asList(2,3,3,5,23);

        //Action
        List<Integer> lstActual = analystToPrimer(n);

        //Assert
        System.out.println(lstActual);
        Assert.assertEquals(lstExpected, lstActual);
    }

    /*
    Bài 9: Viết method nhận vào một số nguyên n. Hãy in ra số Fibonaci ứng với nó.
    Số fibonaci là số thoả mãn f(n) = fi(n-1) + fi(n-2).
     */
    public List<Integer> findFibonaci(int n)
    {
        List<Integer> arrNumber = new ArrayList<Integer>();
        if (n <= 2)
            arrNumber.add(n);
        else
        {
            int i=1;
            int j=2;
            int tong = i+j;
            arrNumber.add(i);
            arrNumber.add(j);
            while(tong <= n)
            {
                arrNumber.add(tong);
                i = j;
                j = tong;
                tong = i+j;
            }
        }
        return arrNumber;
    }

    @Test
    public void check_findFibonaci()
    {
        //Arrange
        int n = 13;
        List<Integer> lstExpected = Arrays.asList(1,2,3,5,8,13);

        //Action
        List<Integer> lstActual = findFibonaci(n);

        //Assert
        System.out.println(lstActual);
        Assert.assertEquals(lstExpected, lstActual);

    }
    /*
    Bài 10: Viết method nhận vào một mảng các số nguyên, hãy viết giải thuật đưa ra danh sách các số chẵn có trong mảng.
    Viết test method cho method vừa viết.
     */

    public List<Integer> findEvenList(List<Integer> arrNumber)
    {
        List<Integer> arrSplits = new ArrayList<Integer>();
        for(int i=0; i<arrNumber.size(); i++)
                if (arrNumber.get(i) %2==0)
                    arrSplits.add(arrNumber.get(i));
        return arrSplits;
    }

    @Test
    public void check_finEvenList()
    {
        //Arrange
        List<Integer> lstInput = Arrays.asList(1,2,3,4,5,6,7,8,9,15);
        List<Integer> lstExpected = Arrays.asList(2,4,6,8);
        //Action
        List<Integer> lstActual = findEvenList(lstInput);

        //Assert
        System.out.println(lstActual);
        Assert.assertEquals(lstExpected, lstActual);
    }

    /*
    Bài 11: Viết method nhận vào một mảng các số nguyên bất kỳ,
    hãy sử dụng method viết ở bài 2, đưa ra danh sách các số nguyên tố có trong mảng.
    Viết test method cho method vừa viết.
     */

    public List<Integer> findPrimerList(List<Integer> arrNumber)
    {
        List<Integer> lstPrimer = new ArrayList<Integer>();
        for(int i=0; i<arrNumber.size(); i++)
            if (isPrimeNumber(arrNumber.get(i)))
                lstPrimer.add(arrNumber.get(i));
        return lstPrimer;
    }
    @Test
    public void check_findPrimerList()
    {
        //Arrange
        int n = 100;
        List<Integer> lstInput = new ArrayList<Integer>(n);
        for(int i=0; i<n; i++)
            lstInput.add(i);

        List<Integer> lstExpected = Arrays.asList(2,3,5,7,9,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97);
        //Action
        List<Integer> lstActual = findPrimerList(lstInput);

        //Assert
        System.out.println(lstActual);
        Assert.assertEquals(lstExpected, lstActual);
    }

    /*
    Bài 12: Viết method nhận vào một mảng các số nguyên, hãy viết giải thuật đảo ngược mảng đó,
            viết test method cho method vừa viết.
     */

    public List<Integer> reverseList(List<Integer> arrNumber)
    {
        List<Integer> lstPrimer = new ArrayList<Integer>();
        int n = arrNumber.size();
        for(int i=n-1; i>=0; i--)
            lstPrimer.add(arrNumber.get(i));
        return lstPrimer;
    }
    @Test
    public void check_reverseList()
    {
        //Arrange
        int n = 10;
        List<Integer> lstInput = new ArrayList<Integer>(n);
        for(int i=0; i<n; i++)
            lstInput.add(i);

        List<Integer> lstExpected = new ArrayList<Integer>(n);
            for(int i=n-1; i>=0; i--)
                lstExpected.add(i);

        //Action
        List<Integer> lstActual = reverseList(lstInput);

        //Assert
        System.out.println(lstActual);
        Assert.assertEquals(lstExpected, lstActual);
    }

    /*
        Bài 13: Viết method nhận vào một mảng các số nguyên và một số nguyên n.'
        Hãy thực hiện lọc ra các số trong mảng này và có giá trị nhỏ hơn số nguyên n.
     */

    public List<Integer> findSmallNumber(List<Integer> arrNumber, int n)
    {
        List<Integer> lst = new ArrayList<Integer>();
        for (int i=0; i< arrNumber.size(); i++)
            if(arrNumber.get(i) < n)
                lst.add(arrNumber.get(i));
        return lst;
    }
    @Test
    public void check_findSmallNumber()
    {
        //Arrange
        int n = 10;
        List<Integer> lstInput = Arrays.asList(9,11,5,7,21,30,4,6,10,8);
        List<Integer> lstExpected = Arrays.asList(9,5,7,4,6,8);

        //Action
        List<Integer> lstActual = findSmallNumber(lstInput, n);

        //Assert
        System.out.println(lstActual);
        Assert.assertEquals(lstExpected, lstActual);
    }
}
