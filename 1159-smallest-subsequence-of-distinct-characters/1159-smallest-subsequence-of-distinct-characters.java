class Solution {
    public String smallestSubsequence(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(!set.contains(s.charAt(i))){
                while(!stack.isEmpty() && stack.peek() > s.charAt(i) && map.containsKey(stack.peek())){
                    set.remove(stack.pop());
                }
                set.add(s.charAt(i));
                stack.push(s.charAt(i));
            }
            if(map.get(s.charAt(i)) == 1){
                map.remove(s.charAt(i));
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return String.valueOf(sb);
    }
}