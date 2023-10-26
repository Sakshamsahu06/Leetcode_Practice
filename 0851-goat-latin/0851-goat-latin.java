class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder goatLatin = new StringBuilder();
        String[] words = sentence.split(" ");
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);

            if (vowels.indexOf(firstChar) != -1) {
                goatLatin.append(word);
            } else {
                goatLatin.append(word.substring(1)).append(firstChar);
            }

            goatLatin.append("ma").append("a".repeat(i + 1));

            if (i < words.length - 1) {
                goatLatin.append(" ");
            }
        }

        return goatLatin.toString();
    }
}