package auxiliares;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import entidades.Cliente;

public class Utilidades 
{
    public boolean isCPFValido(String CPF) {
        if ( CPF.length() != 11 || !CPF.chars().allMatch(Character::isDigit) ) {
            return false;
        }

        return true;
    }

    public static boolean isValorVazio(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isUniqueCPF(String CPF, List<Cliente> list) {
        return list.stream().noneMatch(item -> {
            System.out.println(CPF + " " + item.getCPF());
            return item.getCPF().equals(CPF);
        });
    }

    public static String capitalize(String value) {
        return Arrays.stream(value.split(" "))
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.joining(" "));
    }
}