"""https://www.codewars.com/kata/path-finder-number-2-shortest-path/train/python"""

"""v1 - It seemed not that hard, then scary complex, then stupid simple

1. I thought I just need to wait for all paths to finish, then find the shortest
2. I realized this means I can't use `visited`
   (shorter path won't be found if it crosses a longer, previous path)
   - need to compare with previous steps in same path instead
   - will run much slower
3. EXCEPT how can a later path be shorter?
   1. There's no 'later', because they start growing together and grow at the same rate
   2. If one meets another, the one that was there first has to be shorter
   3. Therefore, path 1st found will automatically be the shortest, and...
      *** I only need to change 1 word in the code ***

- also, I tried to make `paths` and `new_paths` sets instead of lists to speed things up,
  but it made the function ~ 50% slower instead

- to make it clear, this whole solution ended up exactly the same as path-finder-1, except
  `return True` is now `return len(path)-1`
"""

def path_finder(maze):
    next_north = lambda last: (last[0],   last[1]-1)
    next_east  = lambda last: (last[0]+1, last[1])
    next_south = lambda last: (last[0],   last[1]+1)
    next_west  = lambda last: (last[0]-1, last[1])

    maze = maze.split('\n')
    paths = [((0, -1), )]
    visited = set()
    while paths:
        new_paths = []
        for path in paths:
            for extension in (next_north, next_east, next_south, next_west):
                ext = extension(path[-1])
                if all(n >= 0 for n in ext) and ext not in visited:
                    try:
                        if ext == (len(maze[0])-1, len(maze)-1): return len(path)-1
                        if maze[ext[1]][ext[0]] == '.': new_paths.append(path + (ext, ))
                        visited.add(ext)
                    except IndexError: continue
        paths = new_paths
    return False
