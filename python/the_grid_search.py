def solution(grid, R, C, pattern, r, c):
    for grid_row in range(R-r + 1):
        for grid_col in range(C-c + 1):
            if grid[grid_row][grid_col] == pattern[0][0] \
                and grid[grid_row + r - 1][grid_col] == pattern[r - 1][0] \
                and grid[grid_row][grid_col + c - 1] == pattern[0][c-1] \
                and grid[grid_row + r - 1][grid_col + c - 1] == pattern[r-1][c-1]:
                
                mismatch = False
                for p_row in range(r):
                    for p_col in range(c):
                        if grid[grid_row + p_row][grid_col + p_col] != pattern[p_row][p_col]:
                            print(grid[grid_row + p_row][grid_col + p_col], pattern[p_row][p_col], grid_row, grid_col, p_row, p_col)
                            mismatch = True
                            break
                    if mismatch:
                        break
                
                if not mismatch:
                    return 'YES'
    return 'NO'
                
T = int(input())
for t in range(T):
    R, C = [int(x) for x in input().split(' ')]
    P = []
    for row in range(R):
        P.append([int(x) for x in input()])
    r, c = [int(x) for x in input().split(' ')]
    p = []
    for row in range(r):
        p.append([int(x) for x in input()])
    
    print(solution(P, R, C, p, r, c))
