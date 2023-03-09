package com.ittime.PRS;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PRSApplicationTests {

    @Test
    public void contextLoads() {
        boolean[] out = new boolean[64];
        // 定义执行 N 轮，假设为 5 轮
        int N = 5;
        // 从 1 开始报数
        int index = 1;
        joseph(out, index, N);
        for (int i = 0; i < 64; i++) {
            if (!out[i]){
                int num = i+1;
                System.out.print(num+" ");
            }
        }
    }
    public boolean[] joseph(boolean[] out, int index, int N) {
        while (N-- > 0) {
            for (int i = 0; i < 64; i++) {
                if (out[i]) {
                    continue;
                }
                if (index % 5 == 0) {
                    // 第 i 号运动员出局
                    out[i] = true;
                    index = 1;
                } else {
                    index++;
                }
            }
        }
        return out;
    }

    public int[] sort(int[] array) {
        int[] helper = new int[101];
        int[] res = new int[array.length];
        for (int i : array) {
            helper[i]++;
        }
        for (int i = 0, j = 0; i <= 100; i++) {
            if (helper[i] > 0) {
                while (helper[i]-- > 0) {
                    res[j++] = i;
                }
            }
        }
        return res;
    }

}
