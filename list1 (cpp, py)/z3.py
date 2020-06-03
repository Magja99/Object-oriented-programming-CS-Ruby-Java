def add(x, poz, l, p, dict):
    if poz < l:
        for i in range(poz, l):
            dict[i] = '-'
    if poz > p:
        for i in range(p + 1, poz + 1):
            dict[i] = '-'
    dict[poz] = x
    l = []
    for i in dict:
        l.append((i, dict[i]))
    l.sort()
    return dict, l

n = int(input())
l = 0
r = 0
dict = {}
t = []
for i in range(n):
    x, poz = input().split()
    if l == 0 and  r == 0:
        l = int(poz)
        r = int(poz)
    dict, t = add(int(x), int(poz), l, r, dict)
    l = min(l, int(poz))
    r = max(r, int(poz))
    for i in range(len(t)):
        print(t[i][0], ":", t[i][1], sep = '', end = ' ')
    print()
