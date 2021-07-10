package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        test5622();
    }

    private static void test5622() throws Exception {
        // 2:ABC / 3:DEF / 4:GHI / 5:JKL / 6:MNO / 7:PQRS / 8:TUV / 9:WXYZ
        // 입력 - 대문자로 이루어진 단어
        // 출력 - 단어의 길이 + 위 알파벳이 속한 번호의 합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int result = str.length();
        for (char a : str.toCharArray()) {
            switch (a) {
                case 'A' : case 'B' : case 'C' : result += 2; break;
                case 'D' : case 'E' : case 'F' : result += 3; break;
                case 'G' : case 'H' : case 'I' : result += 4; break;
                case 'J' : case 'K' : case 'L' : result += 5; break;
                case 'M' : case 'N' : case 'O' : result += 6; break;
                case 'P' : case 'Q' : case 'R' : case 'S' : result += 7; break;
                case 'T' : case 'U' : case 'V' : result += 8; break;
                case 'W' : case 'X' : case 'Y' : case 'Z' : result += 9; break;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    private static void test2908() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력받은 두 숫자를 거꾸로 읽고, 크기를 비교하여 큰 수를 출력
        //두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        String a = st.nextToken();
        String b = st.nextToken();

        StringBuffer sba = new StringBuffer(a);
        StringBuffer sbb = new StringBuffer(b);
        String aa = String.valueOf(sba.reverse());
        String bb = String.valueOf(sbb.reverse());

        bw.write(Integer.parseInt(aa) > Integer.parseInt(bb) ? aa+"" : bb+"");
        bw.flush();
        bw.close();
    }
    private static void test1152() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다.
        // 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
        // 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        int cnt = 0;
        while(st.hasMoreTokens()){
            cnt++;
            st.nextToken();
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
    private static void test1157() throws Exception {
        //알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
        // 단, 대문자와 소문자를 구분하지 않는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().toUpperCase();
        char[] strArray = str.toCharArray();
        //Arrays.sort(strArray); //aaa bb ccc d
                               //012 34 567 8
        int max = 0;
        int[] counts = new int[26];
        for(int i = 0 ; i < strArray.length ; i++){
            for(int j = 0 ; j < counts.length ; j++){
                if(j == (int)strArray[i]-65) counts[j]++;
            }
        }
        int[] ori = Arrays.copyOf(counts,26);
        Arrays.sort(counts);

        if(counts[24] == counts[25]) bw.write("?");
        else{
            for(int i = 0 ; i < ori.length ; i++){
                if(ori[i] == counts[25]) bw.write((char)(i+65)+"");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void test2675() throws Exception {
        //첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
        // 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
        // S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < cnt ; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for(int k = 0 ; k < str.length() ; k++){
                for(int j = 0 ; j  < n ; j++){
                    bw.write(str.charAt(k));
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void test10809() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] alpha = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String s = br.readLine();
        for(int j=0 ; j < alpha.length ; j++) {
            bw.write(s.indexOf(alpha[j]) + " ");
        }
        bw.flush();
        bw.close();
    }

    private static void test1065() throws Exception {
        /* 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
           등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
           N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
        입력 - 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
        출력 - 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 1 ; i <= n ; i++) {
            if(hansu(i) == true) result++;
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
    private static boolean hansu(int x){
        boolean result;
        //1~99 : 1 2 3 4 5 6 7 8 9 10 11 ~ 98 99
        //111 123 135 147 159
        //210 222 234 246 258
        //321 333 345 357 369
        //420 432 444 456 468
        //531 543 555 567 579
        //630 642 654 666 678
        //741 753 765 777 789
        //840 852 864 876 888
        //951 963 975 987 999

        if(x>=1 && x <100) result = true;
        else if(x==1000) result = false;
        else {
            int a = (x/100)%10 - (x/10)%10;
            int b = (x/10)%10 - x%10;
            if(a == b) result = true;
            else result = false;
        }
        return result;
    }
    private static void test4673() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set set = new HashSet();
        for(int i = 1 ; i < 10001 ; i++){
            set.add(i);
        }
        for(int i = 1 ; i < 10001 ; i++) {
            set.remove(d(i));
        }

        Arrays.stream(set.stream().toArray()).sorted();
        Iterator iterator = set.iterator();
        for(int i = 0 ; i < set.size() ; i++){
            bw.write(iterator.next()+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static int d(int n){
        int sum = 0;
        int m = n;
        if(n < 10){
            sum = n;
        } else {
            while (m != 0) {
                sum += m % 10;
                m = m / 10;
            }
        }
        int result = n + sum;
        return result;
    }

    private static void test4344() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        DecimalFormat form = new DecimalFormat("#.000");
        int n = Integer.parseInt(br.readLine());
        for( int i = 0 ; i < n ; i++ ){
            String ln = br.readLine();
            StringTokenizer st = new StringTokenizer(ln, " ");
            int students = Integer.parseInt(st.nextToken());
            int[] scores = new int[students];
            double upCnt = 0.0;
            int sum = 0;
            double avg = 0;
            double result = 0.0;
            for( int j = 0 ; j < scores.length ; j++ ){
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }
            avg = sum/students;
            for( int j = 0 ; j < scores.length ; j++ ){
                if(scores[j] > avg) upCnt++;
            }
            result = upCnt / (double) students * 100.0;
            bw.write(form.format(result) + "%\n");
        }
        bw.flush();
        bw.close();
    }

//    5
//    5 50 50 70 80 100
//    7 100 95 90 80 70 60 50
//    3 70 90 80
//    3 70 90 81
//    9 100 99 98 97 96 95 94 93 91

//    40.000%
//    57.143%
//    33.333%
//    66.667%
//    55.556%
    private static void test8958() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        for( int i = 0 ; i < cnt ; i++ ) {
            String ox = br.readLine(); // "OOXXOXXOOO"
            int sum = 0;
            int score = 0;
            for( int j = 0 ; j < ox.length() ; j++ ){
                if(ox.charAt(j) == 'O'){
                    score += 1;
                }else{
                    score = 0;
                }
                sum += score;
            }
            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void test1546() throws Exception {
        //세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
        //새로운 평균을 구하자
        //input : 첫줄 - 과목수, 둘째줄 - 점수 나열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        String scores = br.readLine();
        StringTokenizer st = new StringTokenizer(scores);

        double[] scoreArray = new double[cnt];
        double max = 0.0;
        double sum = 0.0;
        double avg = 0.0;

        for( int i = 0 ; i < cnt ; i++ ){
            scoreArray[i] = Double.parseDouble(st.nextToken());
            if( max < scoreArray[i] ) max = scoreArray[i];
        }
        for(double d : scoreArray){
            d = d / max * 100;
            sum += d;
        }

        avg = sum / cnt;
        bw.write(avg + "");
        bw.flush();
        bw.close();
    }

    private static void test2577() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        //TODO :: ABC가 100보다 크고, 1000보다 작은 자연수

        String multi = String.valueOf( A * B * C );

        //A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
        for( int i = 0 ; i < 10 ; i++ ){
            int cnt = 0;
            for( int j = 0 ; j < multi.length() ; j++ ){
                if( String.valueOf(i).equals(Character.toString(multi.charAt(j))) ) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static void test6() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = new int[9];

        for(int i = 0 ; i < 9 ; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int idx = 0;
        for(int i = 0 ; i < 9 ; i++){
            if(max < array[i]){
                idx = i+1;
                max = array[i];
            }
        }
        bw.write(max + "\n");
        bw.write(idx + "");
        bw.flush();
        bw.close();
    }

    private static void test5_1() throws Exception {
        //최대/최소 구하기
        //입력 - 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
        //출력 - 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String arr = br.readLine();
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(arr," ");

        for( int i = 0 ; i < n ; i++ ){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array); //배열을 오름차순으로 정렬해주는 함수
        int max =  array[array.length-1];
        int min = array[0];

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
    }

    private static void test5() throws Exception {
        //최대/최소 구하기
        //입력 - 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
        //출력 - 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String arr = br.readLine();
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(arr," ");

        for( int i = 0 ; i < n ; i++ ){
            array[i] = Integer.parseInt(st.nextToken());
        }

        //Arrays.sort(array); 배열을 오름차순으로 정렬해주는 함수

        int max = array[0];
        int min = array[0];

        for( int i = 0 ; i < n ; i++) {
            if( max < array[i] ) max = array[i];
            if( min > array[i] ) min = array[i];
        }

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
    }

    private static void test4() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean flag = true;
        int cnt = 0;

        String a = br.readLine(); // 0 <= a <= 99
        int ori = Integer.parseInt(a); //26
        while(flag) {
            String b = ori%10 + "" + (ori/10 + ori%10) % 10; //68
            ++cnt;
            if( (a.length()==1 && ("0"+a).equals(b)) || a.equals(b)) {
                flag = false;
                continue;
            }
            ori = Integer.parseInt(b);
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }

    private static void test3() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sum = "";

        boolean flag = true;
        while(flag){
            String a = br.readLine();
            if(a.equals("0 0")){
                flag = false;
                continue;
            }
            StringTokenizer st = new StringTokenizer(a, " ");
            sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n";
            bw.write(sum);
        }
        bw.flush();
        bw.close();
    }

    private static void test2() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(a," ");
        int n = Integer.parseInt(st.nextToken());   //size 10
        int x = Integer.parseInt(st.nextToken());   //test 5

        String b = br.readLine();
        StringTokenizer st2 = new StringTokenizer(b," ");

        for( int i = 0 ; i < n ; i++ ){
            int y = Integer.parseInt(st2.nextToken());
            if( x > y ){
                bw.write(y + " ");
            }
        }
        bw.flush();
        bw.close();

    }

    private static void test1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for( int i = 1 ; i < 10 ; i++ ) {
            System.out.println(n + " * " + i + " = " + n * i);
        }
    }
}

