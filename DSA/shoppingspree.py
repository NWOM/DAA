def max_gift_voucher(N, K, G, P):
    dp = [[0] * (K + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        for j in range(1, K + 1):
            if P[i - 1] <= j:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - P[i - 1]] + G[i - 1])
            else:
                dp[i][j] = dp[i - 1][j]

    return dp[N][K]

# Input
N, K = map(int, input().split())  # First line for N and K
G = list(map(int, input().split()))  # Second line for gift vouchers
P = list(map(int, input().split()))  # Third line for prices

# Function Call
print(max_gift_voucher(N, K, G, P))
