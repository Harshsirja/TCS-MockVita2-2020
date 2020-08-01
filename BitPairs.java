
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Harsh
 */
public class BitPairs {

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            int N = sc.nextInt();
            int numbers[] = new int[N];

            for (int i = 0; i < N; i++) {
                numbers[i] = sc.nextInt();
            }

            int temp;
            int bitscore, min, max, n0, n1, n2;
            int bitScore[] = new int[N];
            int bit1[] = new int[N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                n0 = numbers[i] % 10;
                numbers[i] = numbers[i] / 10;
                n1 = numbers[i] % 10;
                numbers[i] = numbers[i] / 10;
                n2 = numbers[i] % 10;
                numbers[i] = numbers[i] / 10;
                min = Math.min(Math.min(n0, n1), n2);
                max = Math.max(Math.max(n0, n1), n2);
                bitscore = max * 11 + min * 7;
                if (bitscore > 99) {
                    temp = bitscore;
                    bitscore = bitscore / 10;
                    bitscore = bitscore / 10;

                    bitscore = temp - bitscore * 100;
                }
                bitScore[i] = bitscore;
                bit1[i] = bitscore / 10;
            }

            int sig_dig[]=new int[10], i, pairs = 0, msb;

            for (i = 0; i < 10; i++) {
                sig_dig[i] = 0;
            }

            for (i = 0; i < N; i = i + 2) {
                msb = bitScore[i] / 10;
                for (int j = i + 2; j < N; j = j + 2) {
                    if (msb == bitScore[j] / 10) {
                        if (sig_dig[msb] < 2) {
                            sig_dig[msb]++;
                        }
                    }
                }

            }

            for (i = 1; i < N; i = i + 2) {
                msb = bitScore[i] / 10;
                for (int j = i + 2; j < N; j = j + 2) {
                    if (msb == bitScore[j] / 10) {
                        if (sig_dig[msb] < 2) {
                            sig_dig[msb]++;
                        }
                    }
                }
            }

            for (i = 0; i < 10; i++) {
                pairs = pairs + sig_dig[i];
            }

            System.out.println(pairs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
