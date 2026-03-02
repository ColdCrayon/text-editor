# CSC 207: Text Editor

**Authors**:
- John Kafumbe
- Cadel Saszik 

## Resources Used

+ https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
+ https://www.geeksforgeeks.org/java/generics-in-java/

## Changelog

commit 64989bb3d3f7cc79f303a9c1f87448bceb9048c1
Author: johnkafumbe <kafumbejbrown@gmail.com>
Date:   Sun Mar 1 18:30:35 2026 -0600

    Part 4 Complete

commit 82daf69821468c256387297e9a2ebfc0cf7709bc
Author: johnkafumbe <kafumbejbrown@gmail.com>
Date:   Sun Mar 1 16:59:29 2026 -0600

    Part 3 Complete

commit 28ced3cc67174599c9390a26b4ed3e1b8c779ac7
Merge: dfa4619 41748a5
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Sun Mar 1 15:55:05 2026 -0600

    Merge branch 'main' of https://github.com/ColdCrayon/text-editor

commit dfa4619f1fec5d2818c714fb74e5d11eb47ec0e9
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Sun Mar 1 15:54:56 2026 -0600

    Linked List Generic List Operations

commit 41748a548c85100736e741e9ca1b0fb8f7fc2d18
Author: johnkafumbe <kafumbejbrown@gmail.com>
Date:   Thu Feb 26 19:50:59 2026 -0600

    Part 2 Done

commit 31fb5f8c8192315d2ad91fca1e65b0a2d39479de
Author: johnkafumbe <kafumbejbrown@gmail.com>
Date:   Thu Feb 26 16:22:47 2026 -0600

    text-editor Part One Complete

commit 07f13b5365a960b7582b487913b7db472c81402d
Merge: f118d5b a16cad7
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Wed Feb 25 18:21:36 2026 -0600

    Merge branch 'main' of https://github.com/ColdCrayon/text-editor

commit f118d5b507178d2fc133a930c83c171184c4c37d
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Wed Feb 25 18:21:34 2026 -0600

    Interface Test Suite

commit ae826316755407ec5563eded182b1efebf61b772
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Wed Feb 25 18:21:21 2026 -0600

    List Inteface

commit a16cad728f8d75040001c397d2f33c13e5a919b7
Merge: c709546 05e594e
Author: johnkafumbe <kafumbejbrown@gmail.com>
Date:   Wed Feb 25 18:17:01 2026 -0600

    Merge branch 'main' of github.com:ColdCrayon/text-editor

commit c70954699a60de5642bb3e3aecc1db994639c507
Author: johnkafumbe <kafumbejbrown@gmail.com>
Date:   Wed Feb 25 18:04:34 2026 -0600

    Employee Inheritance Done

commit 05e594e1d22c6fa70cfd13ab36d6d6208538856a
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Wed Feb 25 17:46:32 2026 -0600

    ArrayList Test Suite

commit 42c96006cbfee7290ace4c2880c4a1baecbb6fc2
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Wed Feb 25 17:40:56 2026 -0600

    Javadoc Comments

commit a1f9b7f69601a54b4df9b042a0c732320ace26a2
Merge: 4d052ad d2417ce
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Wed Feb 25 17:37:56 2026 -0600

    Merge branch 'main' of https://github.com/ColdCrayon/text-editor

commit 4d052ad4301bf228ddaaef7341079c6add768035
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Wed Feb 25 17:37:16 2026 -0600

    LinkedList Test Suite

commit 5ac1d794aea78262df21dc93b394574cbeec1f5c
Author: Cadel Saszik <sazc0805@gmail.com>
Date:   Wed Feb 25 17:29:17 2026 -0600

    LinkedList init

commit d2417ceb4574b6dd12775b13dd38a1f97cfeb1e7
Author: johnkafumbe <kafumbejbrown@gmail.com>
Date:   Wed Feb 25 17:28:57 2026 -0600

    ArrayList Class Updated

commit e2e2cbe4098acd8e50df992e1475e8d213846e08
Author: Cadel Saszik <96507526+ColdCrayon@users.noreply.github.com>
Date:   Wed Feb 25 16:51:53 2026 -0600

    Initial commit


## Part 2: Analyzing Simple String Buffer Runtime

- Relevant Inputs:
  - n (the number of characters in the buffer)
  - i (the position of the cursor (index))

- Critical Operations
 - substring()
 - + (joining: before, ch and, after)

- Mathmatical Model
 - n + (n + 1) = 2n + 1

- Big-O Characterization
 - The insert method is O(n)

- Justification:
 - Since a string cannot be changed once created, an "insertion" is actually a just a remake. Every time insert is called, Java has to allocate totally new memory for a new string object. 