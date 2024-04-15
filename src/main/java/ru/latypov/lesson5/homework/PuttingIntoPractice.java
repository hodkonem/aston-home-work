package ru.latypov.lesson5.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trader> traders = List.of(raoul, mario, alan, brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(transaction -> System.out.println(transaction.getYear() + " : " + transaction.getValue()));
        System.out.println("____________________________________________");

        // Вывести список неповторяющихся городов, в которых работают трейдеры.
        Stream.of(raoul, mario, alan, brian)
                .collect(Collectors.toMap(Trader::getCity, Trader::getName, (x, y) -> x))
                .forEach((key, value) -> System.out.println(key));
        System.out.println("____________________________________________");

        // Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        traders.stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(trader -> System.out.println(trader.getName()));

        System.out.println("____________________________________________");
        // Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        String collect = traders.stream()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(collect);
        System.out.println("____________________________________________");

        // Выяснить, существует ли хоть один трейдер из Милана.
        boolean milan = traders.stream()
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println("Есть ли трейдер из Милана? " + milan);
        System.out.println("____________________________________________");

        // Вывести суммы всех транзакций трейдеров из Кембриджа.
        Integer cambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);

        System.out.println(cambridge);
        System.out.println("____________________________________________");

        // Какова максимальная сумма среди всех транзакций?
        Optional<Transaction> max = transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue));
        max.ifPresent(transaction -> System.out.println(transaction.getValue()));
        System.out.println("____________________________________________");

        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));
        min.ifPresent(transaction -> System.out.println(transaction.getValue()));
    }
}
