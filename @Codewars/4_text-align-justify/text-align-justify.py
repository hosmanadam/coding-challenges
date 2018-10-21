"""https://www.codewars.com/kata/text-align-justify/train/python"""

import math

def justify(text, width):
  # break string into lines not longer than width
  words = text.split(' ')
  lines = []
  current_line = []
  for i, word in enumerate(words):
    current_line.append(word)
    if (word is words[-1]) or (len(' '.join(current_line + [words[i+1]])) > width):
      lines.append(current_line)
      current_line = []

  # pad lines to final width
  for i, line in enumerate(lines):
    if line is lines[-1]:
      lines[i] = ' '.join(line)
    else:
      spaces_left = width - len(''.join(line))
      for j, word in enumerate(line[:-1]):
        voids_left = len(line[j:-1])
        void_length = int(math.ceil(1.0 * spaces_left / voids_left))
        line[j] += ' ' * void_length
        spaces_left -= void_length
      lines[i] = ''.join(line)

  return '\n'.join(lines)


# TESTS
unaligned = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusce at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. Vivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, non dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at fermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum velit ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellentesque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla et dolor."
print(justify(unaligned, 30)) # Lorem  ipsum  dolor  sit amet,
                              # consectetur  adipiscing  elit.
                              # Vestibulum    sagittis   dolor
                              # mauris,  at  elementum  ligula
                              # tempor  eget.  In quis rhoncus
                              # nunc,  at  aliquet orci. Fusce
                              # at   dolor   sit   amet  felis
                              # suscipit   tristique.   Nam  a
                              # imperdiet   tellus.  Nulla  eu
                              # vestibulum    urna.    Vivamus
                              # tincidunt  suscipit  enim, nec
                              # ultrices   nisi  volutpat  ac.
                              # Maecenas   sit   amet  lacinia
                              # arcu,  non dictum justo. Donec
                              # sed  quam  vel  risus faucibus
                              # euismod.  Suspendisse  rhoncus
                              # rhoncus  felis  at  fermentum.
                              # Donec lorem magna, ultricies a
                              # nunc    sit    amet,   blandit
                              # fringilla  nunc. In vestibulum
                              # velit    ac    felis   rhoncus
                              # pellentesque. Mauris at tellus
                              # enim.  Aliquam eleifend tempus
                              # dapibus. Pellentesque commodo,
                              # nisi    sit   amet   hendrerit
                              # fringilla,   ante  odio  porta
                              # lacus,   ut   elementum  justo
                              # nulla et dolor.
