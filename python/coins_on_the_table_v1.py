N, M, K = [int(x) for x in input().split(' ')]
rows = []
for i in range(N):
    rows.append(input())

grid = [[column for column in row] for row in rows]
actions = ['U', 'D', 'L', 'R']

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.__update_action()
    
    def __update_action(self):
        if self.is_valid():
            self.cur_action = grid[self.y - 1][self.x - 1]
    
    def down(self):
        self.x, self.y = self.x, self.y + 1
        self.__update_action()
        
    def up(self):
        self.x, self.y = self.x, self.y - 1
        self.__update_action()
        
    def right(self):
        self.x, self.y = self.x + 1, self.y
        self.__update_action()
        
    def left(self):
        self.x, self.y = self.x - 1, self.y
        self.__update_action()

    def is_valid(self):
        if self.x < 1 or self.x > M or self.y < 1 or self.y > N:
            return False
        else:
            return True
        
    def get_key(self):
        return str(self.x) + '_' + str(self.y)
        
    def get_cur_action(self):
        return self.cur_action

def run_step(cur_pt, cur_action):
    next_pt = Point(cur_pt.x, cur_pt.y)
    if cur_action == "U":
        next_pt.up()
    elif cur_action == "D":
        next_pt.down()
    elif cur_action == "L":
        next_pt.left()
    elif cur_action == "R":
        next_pt.right()
    
    return next_pt

def find_coin(cur_pt, k, visited=set()):
    if cur_pt.get_cur_action() == '*':
        return 0
    elif k == 0 or not cur_pt.is_valid() or cur_pt.get_key() in visited:
        return -1
    visited.add(cur_pt.get_key())
    
    #print("enter logic:", cur_pt.get_cur_action())
    next_pt = run_step(cur_pt, cur_pt.get_cur_action())
    #print("after runstep:", next_pt.get_cur_action())
    result = find_coin(next_pt, k - 1, visited)
    if result == -1:
        failed_action = cur_pt.get_cur_action()
        #print('failed action: ' + failed_action)
        for action in filter(lambda action: action != failed_action, actions):
            #print('---------')
            #print('trying action: ' + action)
            next_pt = run_step(cur_pt, action)
            #print('next point:', str(next_pt.x), str(next_pt.y), next_pt.get_cur_action())
            other_result = find_coin(next_pt, k - 1, visited)
            #print('other result:', other_result)
            if other_result >= 0:
                result = 1 + other_result
                break;
                
    visited.remove(cur_pt.get_key())
    return result

#print(N,M,K)
#print(grid[0][0], grid[0][1])
#print(grid[1][0], grid[1][1])
start_pt = Point(1,1)
result = find_coin(start_pt, K, set())
print(result)
            

