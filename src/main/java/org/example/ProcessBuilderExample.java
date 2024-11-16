package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ProcessBuilderExample {
    public static void main(String[] args) {
        // ProcessBuilder ile 'ls -l' komutunu çalıştırmak için bir ProcessBuilder nesnesi oluşturuyoruz
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", "ls -l"); // Ubuntu'da bash shell kullanarak komut çalıştırıyoruz

        try {
            // Process başlatılıyor
            Process process = processBuilder.start();

            // Komutun çıktısını okumak için InputStreamReader kullanıyoruz
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Çıktıyı satır satır okuyup ekrana yazdırıyoruz
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // İşlemin tamamlanmasını bekliyoruz
            int exitCode = process.waitFor();
            System.out.println("\nÇıkış Kodu : " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
