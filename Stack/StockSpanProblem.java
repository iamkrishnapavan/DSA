/*
    We stored previous greater element index and return current - previous greater index
 */
class StockSpanner {
    public Stack<Integer> stack;
    public List<Integer> res;
    public StockSpanner() {
        this.stack = new Stack<Integer>();
        this.res = new ArrayList<Integer>();
    }

    public int next(int price) {
        res.add(price);
        while(!stack.isEmpty() && res.get(stack.peek()) <= price) stack.pop();
        int r = stack.isEmpty() ? res.size() : (res.size() - stack.peek() - 1);
        stack.push(res.size() - 1);
        return r;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */