package util;

public class Cls {
    public static void cls() {
        // 检查操作系统类型
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            // 如果是Windows系统，使用"cls"命令清屏
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                // 处理异常
                System.out.println("清屏失败");
            }
        } else {
            // 如果是其他系统，使用ANSI转义序列清屏
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

    }
}
