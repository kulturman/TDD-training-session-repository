import {Fizzbuzz} from "./fizzbuzz";

describe('Fizzbuzz tests', function () {
    let fizzbuzz: Fizzbuzz;

    beforeEach(() => {
        fizzbuzz = new Fizzbuzz();
    });

    it('returns Fizz if number is mutiple of 3', () => {
        expect(fizzbuzz.transform(3)).toEqual("Fizz");
    })

    it('returns Buzz if number is mutiple of 5', () => {
        expect(fizzbuzz.transform(5)).toEqual("Buzz");
    })

    it('returns FizzBuzz if number is both mutiple of 3 and 5', () => {
        expect(fizzbuzz.transform(30)).toEqual("FizzBuzz");
    })

    it('returns number itself if its not multiple or 3 or 5', () => {
        expect(fizzbuzz.transform(8)).toEqual('8');
    })
});
