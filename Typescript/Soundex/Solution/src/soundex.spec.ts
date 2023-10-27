import {Soundex} from "./soundex";

describe('Soundex test', () => {
    let soundex: Soundex;

    beforeEach(() => {
        soundex = new Soundex();
    });

    it('retains first letter of one letter word', () => {
        expect(soundex.generate("A")).toEqual("A000");
    })

    it('uppercase first letter', () => {
        expect(soundex.generate("a")).toEqual("A000");
    })

    it('pads result with zeros', () => {
        expect(soundex.generate("I")).toEqual("I000");
    })

    it('encodes other characters accordingly to soundex map', () => {
        expect(soundex.generate("AR")).toEqual("A600")
    })

    it('encodes multiple consonants', () => {
      expect(soundex.generate("ABK")).toEqual("A120");
      expect(soundex.generate("ABT")).toEqual("A130");
    })

    it('generates 4 letters code', () => {
        expect(soundex.generate("ABKRN").length).toEqual(4);
    });

    it('ignores vowels and W and H', () => {
        expect(soundex.generate("AA")).toEqual("A000");
        expect(soundex.generate("ABYB")).toEqual("A110");
    })

    it('encodes adjacent letters that encodes to the same value once', () => {
        expect(soundex.generate("ABBR")).toEqual("A160");
    })
})
