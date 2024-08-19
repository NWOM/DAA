
def next_permutation (n, arr):
    
    pivot = -1
    
    # Step 1: Find the pivot
    for i in range(len(arr) - 1, 0, -1):
        if arr[i] > arr[i - 1]:
            pivot = i - 1
            break  # Break once we find the pivot
    
    # If there is a valid pivot
    if pivot != -1:
        max_pos = -1
        
        # Step 2: Find the element to swap with the pivot
        for i in range(len(arr) - 1, pivot, -1):
            if arr[i] > arr[pivot]:
                max_pos = i
                break
        
        # Step 3: Swap
        arr[pivot], arr[max_pos] = arr[max_pos], arr[pivot]
    
    # Step 4: Reverse the suffix
    arr[pivot + 1:] = reversed(arr[pivot + 1:])
    
    return arr
    

n = int(input())
arr = list(map(int, input().split()))

out_ = next_permutation(n, arr)
print (' '.join(map(str, out_)))
