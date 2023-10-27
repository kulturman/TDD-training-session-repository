export class Soundex {
    private readonly MAX_ENCODED_VALUE_LENGTH = 4;

    generate(word: string) {
        let encodedWord = word[0].toUpperCase();

        encodedWord += this.encodeWordTail(word.substring(1));

        return this.addZerosPad(encodedWord);
    }

    private encodeWordTail(word: string): string {
        let encodedValue = "";
        let lastEncodedValue: string | undefined = "";

        for (let letter of word) {
            if (this.encodingIsComplete(encodedValue))
                break;

            const currentEncodedValue = this.encodeLetter(letter);

            if (this.encodeLetter(letter) !== undefined && lastEncodedValue !== currentEncodedValue) {
                encodedValue += this.encodeLetter(letter);
            }

            lastEncodedValue = this.encodeLetter(letter);
        }
        return encodedValue;
    }

    private encodingIsComplete(encodedValue: string) {
        return encodedValue.length === this.MAX_ENCODED_VALUE_LENGTH - 1;
    }

    private addZerosPad(encodedWord: string) {
        const zerosToAdd = this.MAX_ENCODED_VALUE_LENGTH - encodedWord.length;

        return encodedWord + "0".repeat(zerosToAdd);
    }

    private encodeLetter(letter: string) {
        const encodingMap: Map<string, string> = new Map<string, string>([
            ['b', '1'], ['f', '1'], ['p', '1'], ['v', '1'],
            ['c', '2'], ['g', '2'], ['j', '2'], ['k', '2'], ['q', '2'],
            ['s', '2'], ['x', '2'], ['z', '2'],
            ['d', '3'], ['t', '3'],
            ['l', '4'],
            ['m', '5'], ['n', '5'],
            ['r', '6']
        ]);

        return encodingMap.get(letter.toLowerCase());
    }
}
