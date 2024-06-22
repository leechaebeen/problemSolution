package actual.unionfind;

// https://www.acmicpc.net/problem/1043

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 진실을 아는 사람1과 모르는 사람 2가 같은 파티에 있으면
// 진실을 말해야 하므로 모르는 사람2도 진실을 알게된다. 그래서 같은 집합에 들어가는 것.
public class 거짓말쟁이가되긴싫어_052 {

    private static int[] parent; // 대표 노드 저장 배열
    private static int[] truePeople;// 진실을 아는 사람
    private static ArrayList<Integer>[] party; // 파티 데이터
    private static int result; // 과장할 수 있는 파티 수

    public static void main(String[] args) {
        // 입력값 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람 수 4
        int M = sc.nextInt(); // 파티 수 3
        int T = sc.nextInt(); // 진실을 아는 사람 수 0
        result = 0;
        truePeople = new int[T];
        // 진실을 아는 사람 저장
        for(int i=0; i<T; i++) {
            truePeople[i] = sc.nextInt();
        }

        // 파티 데이터 저장
        party = new ArrayList[M];
        for(int i=0; i<M; i++) {
            int partySize = sc.nextInt(); // 2
            party[i] = new ArrayList<>();
            for(int j = 0; j < partySize; j++) {
                party[i].add(sc.nextInt());
            }
        }

        System.out.println(Arrays.toString(party));

        // 대표 노드 자신으로 초기화
        parent = new int[N+1]; // 사람 번호 1부터 시작하므로
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        // 각 파티에 참여한 사람 한 그룹으로 만들기
        for(int i=0; i<M; i++) {
            int firstPerson = party[i].get(0);
            for(int j=1; j<party[i].size(); j++) {
                union(firstPerson, party[i].get(j));
            }
        }

        // 각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음
        for(int i=0; i<M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j=0; j<truePeople.length; j++) {
                if(find(cur) == find(truePeople[j])) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a!=b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if(parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
