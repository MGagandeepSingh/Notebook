package com.notebook;

import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import javax.sound.midi.Soundbank;

@Slf4j
public class MonoCreatingSequence {

    public static void main(String[] args) throws InterruptedException {

        Mono<String> x = Mono.just(method("A"));

        Mono<String> y = Mono.fromSupplier(() -> method("B"));

        Thread.sleep(3000);

        x.subscribe();
        y.subscribe();


        log.info("\n---------------------\n");

        Mono<Double> randomNumber = Mono.fromSupplier(MonoCreatingSequence::randomNumber);
        randomNumber.subscribe(System.out::println);
        randomNumber.subscribe(System.out::println);
        randomNumber.subscribe(System.out::println);
        randomNumber.subscribe(System.out::println);
        randomNumber.subscribe(System.out::println);

        log.info("Here comes the real deal");
        Mono<Double> randomNumberEveryTime = Mono.defer(() -> Mono.just(randomNumber()));
        randomNumberEveryTime.subscribe(System.out::println);
        randomNumberEveryTime.subscribe(System.out::println);
        randomNumberEveryTime.subscribe(System.out::println);
    }

    private static double randomNumber() {
        return Math.random();
    }

    private static String method(String name) {

        log.info("Executed for username: {}", name);
        return name;
    }
}
