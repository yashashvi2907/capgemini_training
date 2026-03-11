package dsa_practice;

import java.util.*;


public class Arrays {


    public static void main()
    {

    }
    public static void ArrayTraversal(int[] arr)
    {
        // using for loop - O(n)
        for(int i =0; i<arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        // using iteration - O(n)
        for(int it : arr)
        {
            System.out.println(it);
        }
    }
    public static int largestelement(int[] arr)
    {
        int n = arr.length;
        long max = Long.MIN_VALUE;

        for( int i =0; i<n; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
       return (int)max;
    }
    public static int secondlargest(int[] arr)
    {
        int n = arr.length;
        long max = Long.MIN_VALUE;
        long sec_max = Long.MIN_VALUE;

        for(int i =0; i<n; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
            else if(arr[i] > sec_max && max != max)
            {
                sec_max = arr[i];
            }
        }
        return (int)sec_max;
    }
    public static void insertionatbeg(int[] arr, int element)
    {
        int n = arr.length;

        for(int i = n-1; i > 0; i--)
        {
            arr[i] = arr[i-1];
        }
        arr[0] = element;
        n++;
    }
    public static void insertatpos(int[] arr, int element, int pos)
    {
        int n = arr.length;

        for(int i = n-1; i > pos ; i--)
        {
            arr[i]=arr[i-1];
        }
        arr[pos] = element;
        n++;
    }

    public static void rotateleft(int[] arr, int k)
    {
        int n = arr.length;

//        reverse(arr, 0, k-1);
//        reverse(arr, k, n-1);
//        reverse( arr, 0, n-1);

    }
    public static void rotateright(int[]arr, int k)
    {
        int n = arr.length;

//        reverse(arr,0,n-1);
//        reverse(arr,0,k-1);
//        reverse(arr, k, n-1);
    }
    public static void move0toend(int[]arr)
    {
        int n = arr.length;
        int j =-1;

        for( int i =0; i<n; i++)
        {
            if(arr[i] == 0)
            {
                j = i;
                break;
            }
        }
        if(j == -1)
        {
            // no zero present
        }

        for(int i = j+1; i<n; i++)
        {
            if(arr[i] != 0)
            {
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
    }

    public static void missingnum(int[] arr)
    {
         int n = arr.length + 1;
         int xor1 = 0;
         int xor2 = 0;

         for( int i =0; i < n - 1; i++)
         {
             xor2 ^= arr[i];
         }
         for(int i = 1; i <= n; i++)
         {
             xor1^=i;
         }
         int mis_num = xor1^xor2;
         // return mis_num;
    }

    public static void maxconsecutiveones(int[] arr)
    {
        int count = 0;
        int maxi = 0;
        int n = arr.length;

        for(int i =0; i<n; i++)
        {
            if(arr[i] == 1)
            {
                count++;
            }
            else {
                count = 0;
            }
            maxi = Math.max(count, maxi);
        }
        //return maxi;
    }
    public static void longestsubarraywithgivensum(int[] arr, int k)
    {
        int n = arr.length;
        int left = 0;
        int right = 0;
        int maxlen = 0;
        int sum =0;

        while(right < n)
        {
           // expand window
           if(right < n)
           {
               sum+=arr[right];
           }

           // shrink window
           while(left <=right && sum > k)
           {
               sum-=arr[left];
               left++;
           }
           //check validity -
            if(sum==k)
            {
                maxlen = Math.max(maxlen, right-left+1);
            }
           right++;
        }
    }

    public static void twosum(int[] arr, int target)
    {
        // twosum works only on sorted array
        // if not sorted, sort in a way
        int n = arr.length;

        int left = 0;
        int right = n-1;
        int sum =0;

        int[][] numswithIndex = new int[n][2];

        for(int i = 0; i < n; i++)
        {
            numswithIndex[i][0] = arr[i];
            numswithIndex[i][1] = i;
        }

        java.util.Arrays.sort(numswithIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[0], b[0]);
            }
        });

        while(left < right)
        {
            sum = numswithIndex[left][0]+numswithIndex[right][0];

            if(sum == target)
            {
                // return {numswithIndex[left][1], numswithIndex[right][1]};
            }
            if(sum > target)
            {
                right--;
            }
            if(sum < target)
            {
                left++;
            }
        }
    }
    public static void sort012(int[] arr)
    {
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid <= high)
        {
            if(arr[mid] == 0)
            {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if (arr[mid] == 1)
            {

                mid++;
            }
            else
            {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
    public static void majorityelement1(int[] arr)
    {
        int count = 0;
        int n = arr.length;
        int ele = 0;

        for( int i =1; i<n; i++)
        {
            if(count == 0)
            {
                count = 1;
                ele = arr[i];
            }
            else if(ele == arr[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        int cnt1 = 0;
        for( int i =0; i<n; i++)
        {
            if(arr[i] == ele)
            {
                cnt1++;
            }
        }
        //if(cnt1 > n/2) // return ele;
    }

    public static void maxsubarraysum(int[] arr)
    {
        int n = arr.length;
        long maxi = Long.MIN_VALUE;
        long sum =0;
        int ansstart=-1;
        int ansend = -1;
        int start = 0;


        for(int i =0; i<n; i++)
        {
            if(sum == 0)
            {
                start = i;
            }
              sum+= arr[i];

              if(sum > maxi)
              {
                  maxi = sum;
                  ansstart = start;
                  ansend = i;
              }
              if(sum < 0)
              {
                  sum = 0;
              }
        }
        //return (int) maxi;
    }
    public static void rearranggeelementbysign(int[] arr)
    {

        int posindex = 0;
        int negindex = 1;
        int n = arr.length;
        int[] ans = new int[n];

        for( int i = 0; i<n; i++) {
            if (arr[i] < 0) {
                ans[negindex] = arr[i];
                negindex += 2;
            } else {
                ans[posindex] = arr[i];
                posindex += 2;
            }
        }
    }

    public static void leaderinarray(int[] arr)
    {
        int n = arr.length;

       List<Integer>ans = new ArrayList<>();
       int maxi = arr[n-1];
       ans.add(arr[n-1]);


       for(int i = n-2; i>=0; i--)
       {
           if(arr[i] > maxi)
           {
               ans.add(arr[i]);
               maxi = arr[i];
           }
       }
    }

    public static void longestconsecutivesequence(int[] arr)
    {

        int n = arr.length ;

        int longest = 1;

        Set<Integer>st  = new HashSet<>();

        for( int i = 0; i < n; i++)
        {
            st.add(arr[i]);
        }
        for(int it : st)
        {
            if(!st.contains(it-1))
            {
                int cnt = 1;
                int x = it;

                while(st.contains(x+1))
                {
                    x = x+1;
                    cnt = cnt+1;
                }

                longest = Math.max(longest, cnt);
            }
        }
        // return longest;
    }

    public static void setmatrixzeroes(int[][] arr)
    {
        int m = arr.length;
        int n = arr[0].length;

        boolean firstrow = false, firstcol = false;

        for(int i = 0 ; i<n; i++)
        {
          if(arr[0][i] == 0)
          {
              firstrow = true;
              break;
          }
        }
        for(int j = 0; j<m; j++)
        {
            if(arr[j][0] == 0)
            {
                firstcol = true;
                break;
            }
        }

        for(int i=1; i<m; i++)
        {
          for(int j =1; j<n; j++)
          {
              if(arr[i][j] == 0)
              {
                  arr[0][j]=0;
                  arr[i][0]=0;
              }
          }
        }
        for(int i =1; i<m; i++)
        {
            for(int j = 1; j<n; j++)
            {
                if(arr[0][j]==0 || arr[i][0]==0)
                {
                    arr[i][j]=0;
                }
            }
        }

        if(firstrow)
        {
            for(int i =0; i<n; i++)
            {
                arr[0][i]= 0;
            }
        }
        if(firstcol)
        {
            for(int i = 0; i<m; i++)
            {
                arr[i][0]=0;
            }
        }

    }
    public static void rotateby90(int[][]arr)
    {
        int n = arr.length;
        int m = arr[0].length;

        // transpose along diagonal

        for(int i =0; i<m; i++)
        {
            for(int j =i+1; j<n; j++)
            {
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i] = temp;
            }
        }
        //reverse each row

        for(int i =0; i<n; i++)
        {
            int left = 0; int right = m-1;

            while(left < right)
            {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
            }

        }
    }
    public static void spiralmatrix(int[] arr)
    {


    }


}



