"""https://www.codewars.com/kata/path-finder-number-1-can-you-reach-the-exit/train/python"""


"""v1 - First try, working pretty good: explores 500x500 maze in ~ 5 seconds

- coordinates are represented as (x, y), use in reverse order for indexing
- paths are tuples of tuples, signifying that we're not modifying any existing paths
- lambdas take 1 pair of coordinates and return their neighbor
- process:
  - we start outside the "entrance" at (0, -1), from where the only possible NSEW step is (0, 0)
    (this is so that on a 1x1 maze, (0, 0) can be "found" as an exit)
  - for each path, we explore possible extensions, and
    - return True if extension is end of maze
    - skip if it's outside board, has negative index, or already visited
    - if empty, add to visited and save as new path
    - if wall, add to visited (this is done passively, not even mentioned in the code)
  - all previous paths are discarded, replaced with list of new
  ↳ repeat until exit is found or all options are depleted
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
                        if ext == (len(maze[0])-1, len(maze)-1): return True
                        if maze[ext[1]][ext[0]] == '.': new_paths.append(path + (ext, ))
                        visited.add(ext)
                    except IndexError: continue
        paths = new_paths
    return False


"""Top CW solution

- much faster than mine
- seems to use variable names that come from algorithmic terminology
- I have no idea how it works, even though it shares some traits with mine
- I'm sure I'll understand once I go deeper into algorithms
"""
# def path_finder(maze):
#     g = maze.splitlines()
#     end, bag = len(g[0]) -1 + len(g) * 1j - 1j, {0}
#     grid = {x + y * 1j for y,l in enumerate(g) for x,c in enumerate(l) if '.' == c}
#     while bag:
#         if end in bag: return True
#         grid -= bag
#         bag = grid & set.union(*({z + 1j ** k for k in range(4)} for z in bag))
#     return False
