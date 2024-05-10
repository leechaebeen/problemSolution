package basic.datastructure.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호_009 {

    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());   //  문자열 크기
        int P = Integer.parseInt(st.nextToken());   // 부분 문자열 크기
        int Result = 0;
        char[] A = new char[4];    // 입력 받은 문자열
        checkArr = new int[4];     // 체크할 문자 수 배열
        myArr = new int[4];        // 현재 문자 수 배열
        checkSecret = 0;           // 유효성 통과한 문자 수

        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){
                checkSecret++;
            }
        }

        // 부분 문자열 크기만큼 반복하고 유효성 체크
        for(int i = 0; i < P; i++) {
            addChar(A[i]);
        }
        if(checkSecret == 4) {
            Result++;
        }

        // !슬라이딩 윈도우 처리 부분
        for(int i = P; i < S; i++) {
            int j = i-P;
            addChar(A[i]);
            removeChar(A[j]);
            if(checkSecret == 4) {
                Result++;
            }
        }

        System.out.println(Result);
        bf.close();
    }

    public static void addChar(char ch) {
        if(ch == 'A') {
            myArr[0]++;
            validAddChar(0);
        } else if (ch == 'C') {
            myArr[1]++;
            validAddChar(1);
        } else if (ch == 'G') {
            myArr[2]++;
            validAddChar(2);
        } else if (ch == 'T') {
            myArr[3]++;
            validAddChar(3);
        }
    }

    public static void removeChar(char ch) {
        if(ch == 'A') {
            validRemoveChar(0);
            myArr[0]--;
        } else if (ch == 'C') {
            validRemoveChar(1);
            myArr[1]--;
        } else if (ch == 'G') {
            validRemoveChar(2);
            myArr[2]--;
        } else if (ch == 'T') {
            validRemoveChar(3);
            myArr[3]--;
        }
    }

    public static void validAddChar(int i) {
        if(checkArr[i] == myArr[i]) {
            checkSecret++;
        }
    }

    public static void validRemoveChar(int i) {
        if(checkArr[i] == myArr[i]) {
            checkSecret--;
        }
    }
}
