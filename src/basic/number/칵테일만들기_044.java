package basic.number;

import java.util.*;
import java.io.*;


class 칵테일만들기_044 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static long[] nums;
    private static ArrayList<ArrayList<Integer>> edge = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        setNums();
        for(int i = 0; i < N; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    // 모든 재료들의 업데이트된 질량을 최대공약수를 구하고 나눈다.
    private static void setNums(){
        long gcd = gcd(nums[0], nums[1]);
        while(gcd > 1){
            for(int i = 0; i < N; i++) gcd = gcd(gcd, nums[i]);
            for(int i = 0; i < N; i++) nums[i] /= gcd; //
        }
    }

    // 입력값 초기화 및 계산
    private static void input() throws Exception{
        N = Integer.parseInt(br.readLine());
        nums = new long[N+5];
        for(int i = 0; i < N; i++) {
            edge.add(new ArrayList<>());
            nums[i] = 1;
        }
        for(int i = 0; i < N-1; i++){
            int a, b;
            long p, q;
            String[] read = br.readLine().split(" ");
            a = Integer.parseInt(read[0]);
            b = Integer.parseInt(read[1]);
            p = Long.parseLong(read[2]);
            q = Long.parseLong(read[3]);
            long gcd = gcd(p, q);
            calc(a, b, p / gcd, q / gcd);
        }
    }

    // 최대 공약수
    private static long gcd(long a, long b){
        while(b > 0){
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    /*
        문제에서 두가지 재료의 비율이 주어진다.
        이 비율을 갖고 각 재료의 질량을 구하는 공식을 만들어보면,
        재료를 각각 a,b 비율을 p,q라 했을때,

        1. 재료 a의 질량 = 재료b의 질량 * 재료a의 질량 * p
        2. 재료 b의 질량 = 재료a의 질량 * 재료b의 질량 * q

        이때, 재료 a와 b가 늘어남에따라 각 재료들에 연결된 다른 재료들또한 업데이트 해줘야한다.
        재료 a와 재료 b 사이의 비율을 유지하기위해 각 재료에 곱한값을 연결된 재료들에 각각 곱해주자.
    * */
    private static void calc(int a, int b, long p, long q){
        Boolean[] check = new Boolean[N+5];
        long tempA = nums[a];
        long tempB = nums[b];
        update(a, tempB*p, check);
        update(b, tempA*q, check);
        edge.get(a).add(b);
        edge.get(b).add(a);
    }

    private static void update(int target, long num, Boolean[] check){
        nums[target] *= num;
        check[target] = true;
        for(int i = 0; i < edge.get(target).size(); i++){
            if(check[edge.get(target).get(i)] != null) continue;
            update(edge.get(target).get(i), num, check);
        }
    }

}