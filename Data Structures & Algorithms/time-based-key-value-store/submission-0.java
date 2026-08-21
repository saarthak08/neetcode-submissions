class TimeMap {
    class Data {
        int num;
        String value;
        public Data(int num, String val) {
            this.num = num;
            this.value = val;
        }
    }

    HashMap<String, ArrayList<Data>> ds;

    public TimeMap() {
        ds = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ArrayList<Data> list = ds.computeIfAbsent(key, (k) -> new ArrayList<>());
        list.add(new Data(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (ds.containsKey(key)) {
            ArrayList<Data> list = ds.get(key);
            return searchInMap(list, timestamp);
        } else {
            return "";
        }
    }

    private String searchInMap(ArrayList<Data> list, int ts) {
        if (list.isEmpty()) {
            return "";
        }
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int n = list.get(m).num;
            if (n == ts) {
                return list.get(m).value;
            }
            if (n < ts) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (r == -1) {
            return "";
        } else {
            return list.get(r).value;
        }
    }
}
