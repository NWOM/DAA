def fact(n):
    p=1
    while n>1:
        p*=n
        n-=1
    return p
def kth_combi (n, k):
    arr=[(i+1) for i in range(n)]
    k-=1
    res=""
    while len(arr)>0:
        div=fact(len(arr)-1)
        delete_pos=k//div
        res += str(arr[delete_pos])
        arr.pop(delete_pos)
        k%=div
    return res
n = int(input())
k = int(input())

out_ = kth_combi(n, k)
print (out_)
