use std::cmp::Reverse;
use std::collections::{BinaryHeap, VecDeque};
use std::future::Future;
use std::process::id;

pub fn string_sequence(target: String) -> Vec<String> {
    let mut result = Vec::new();
    let mut screen = String::new();
    for c in target.chars() {
        screen.push('a');
        result.push(screen.clone());
        let mut j = 'a';
        while j != c {
            j = (j as u8 + 1) as char;
            screen.pop();
            screen.push(j);
            result.push(screen.clone());
        }
    }
    result
}

pub fn k_closest(points: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
    let mut pq: BinaryHeap<Reverse<(i32, Vec<i32>)>> = BinaryHeap::new();
    let k = k as usize;
    for point in points {
        let distance = point[0] * point[0] + point[1] * point[1];
        pq.push(Reverse((distance, point.clone())));
        if pq.len() > k {
            pq.pop();
        }
    }

    let mut res = Vec::with_capacity(k);
    while let Some(Reverse((_, point))) = pq.pop() {
        res.push(point);
    }
    res
}

pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let n = img.len() as i32;
    let m = img[0].len() as i32;
    let mut ans = vec![vec![0; m as usize]; n as usize];
    let dx = [-1, -1, -1, 0, 0, 0, 1, 1, 1];
    let dy = [-1, 0, 1, -1, 0, 1, -1, 0, 1];
    for i in 0..n {
        for j in 0..m {
            let mut sum = 0;
            let mut count = 0;
            for k in 0..9 {
                let ni = i + dx[k];
                let nj = j + dy[k];
                if nj < n && nj < m {
                    sum += img[ni as usize][nj as usize];
                    count += 1;
                }
            }
            ans[i as usize][j as usize] = sum / count;
        }
    }
    ans
}

pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
    if nums.len() == 1 {
        return 1;
    }
    let mut c = 1;
    let mut max = 0;
    let mut prev = nums[0];
    for num in nums {
        if num > prev {
            c += 1
        } else {
            c = 1;
            max = i32::max(max, num);
        }
        prev = num;
    }
    i32::max(max, c)
}

pub fn cal_points(operations: Vec<String>) -> i32 {
    let mut stack = VecDeque::new();
    for operation in operations {
        match operation.chars().next().unwrap() {
            '+' => {
                let a = stack.pop_back().unwrap();
                let b = stack.pop_back().unwrap();
                stack.push_back(b);
                stack.push_back(a);
                stack.push_back(a + b);
            }
            'D' => {
                let a = stack.back().unwrap();
                stack.push_back(a * 2);
            }
            'C' => {
                stack.pop_back();
            }
            _ => {
                let num: i32 = operation.parse().unwrap();
                stack.push_back(num);
            }
        }
    }
    stack.iter().sum()
}

pub fn sort_vowels(s: String) -> String {
    let mut chars: Vec<char> = vec!['\0'; s.len()];
    let mut vowels = [0; 58];

    vowels[0] = 1;
    vowels[4] = 1;
    vowels[8] = 1;
    vowels[14] = 1;
    vowels[20] = 1;
    vowels[32] = 1;
    vowels[36] = 1;
    vowels[40] = 1;
    vowels[46] = 1;
    vowels[52] = 1;

    for (i, c) in s.chars().enumerate() {
        let index = (c as u8 - 65) as usize;
        if vowels[index] != 0 {
            vowels[index] += 1;
        } else {
            chars[i] = c;
        }
    }

    for i in 0..chars.len() {
        if chars[i] == '\0' {
            let mut j = 0;
            while vowels[j] <= 1 {
                j += 1;
            }
            vowels[j] -= 1;
            chars[i] = (j as u8 + 65) as char;
        }
    }

    chars.into_iter().collect()
}

pub fn is_one_bit_character(bits: Vec<i32>) -> bool {
    if bits[bits.len() - 1] == 1 {
        return false;
    }
    let mut i = 0;
    while i < bits.len() - 1 {
        if bits[i] == 1 {
            i += 1;
        }
    }
    i < bits.len()
}

pub fn search(nums: Vec<i32>, target: i32) -> i32 {
    let mut l = 0;
    let mut r = nums.len() - 1;
    while l <= r {
        let m = l + (r - l) / 2;
        if nums[m] == target {
            return m as i32;
        } else if nums[m] > target {
            if m == 0 {
                return -1;
            }
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    -1i32
}

pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
    let mut m = [0; 26];
    letters.iter().for_each(|letter| {
        m[*letter as usize - 97] += 1;
    });
    for i in (target as usize - 96)..26 {
        if m[i] > 0 {
            return (i as u8 + 97) as char;
        }
    }
    letters[0]
}

pub fn min_cost_climbing_stairs(cost: Vec<i32>) -> i32 {
    let mut dp = vec![0; cost.len() + 2];
    for i in (0..=(cost.len() - 1)).rev() {
        dp[i] = cost[i] + i32::min(dp[i + 1], dp[i + 2]);
    }
    i32::min(dp[0], dp[1])
}

/*
public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int j = 0;
            while (j < boxes.length()) {
                if (j != i && boxes.charAt(j) == '1') {
                    res[i]+=Math.abs(j-i);
                }
                j++;
            }
        }
        return res;
    }
*/

pub fn min_operations(boxes: String) -> Vec<i32> {
    let mut ans = vec![0; boxes.len()];
    let boxes_vec = boxes.chars().collect::<Vec<char>>();
    for i in 0..boxes.len() {
        let mut j = 0;
        while j < boxes.len() {
            if i != j && boxes_vec[j] == '1' {
                ans[i] += i32::abs((j - i) as i32);
            }
            j += 1;
        }
    }
    ans
}

pub fn is_acronym(words: Vec<String>, s: String) -> bool {
    if s.is_empty() || s.len() != words.len() {
        return false;
    }
    for (i, c) in s.chars().enumerate() {
        if words[i].chars().next().unwrap() != c {
            return false;
        }
    }
    true
}

pub fn minimum_right_shifts(nums: Vec<i32>) -> i32 {
    let n = nums.len();
    if nums[n - 1] > nums[0] {
        return -1;
    }
    let mut idx = n + 1;
    for i in 1..n {
        if nums[i - 1] > nums[i] {
            if idx != n + 1 {
                return -1;
            }
            idx = i;
        }
    }
    if idx == n + 1 {
        return 0;
    }
    (n - idx) as i32
}

pub fn sum_indices_with_k_set_bits(nums: Vec<i32>, k: i32) -> i32 {
    let mut sum = 0;
    let k = k as u32;
    nums.iter().enumerate().for_each(|(i, num)| {
        if i.count_ones() == k {
            sum += num;
        }
    });
    sum
}

pub fn min_operations_2869(nums: Vec<i32>, k: i32) -> i32 {
    let mut mark = 0;
    let mut count = 0;
    let mut arr = vec![0; k as usize + 1];
    for i in (0..nums.len()).rev() {
        if mark == k {
            break;
        }
        let num = nums[i];
        if num <= k && arr[i] == 0 {
            mark += 1;
            arr[num as usize] = 1;
        }
        count += 1;
    }
    count
}

pub fn last_visited_integers(nums: Vec<i32>) -> Vec<i32> {
    let mut seen = vec![];
    let mut ans = vec![];
    let mut k = 0usize;

    for num in nums {
        if num != -1 {
            seen.push(num);
            k = 0;
        } else {
            ans.push(if seen.len() > k {
                seen[seen.len() - k - 1]
            } else {
                -1
            });
            k += 1;
        }
    }
    ans
}

pub fn find_indices(nums: Vec<i32>, index_difference: i32, value_difference: i32) -> Vec<i32> {
    for i in 0..nums.len() {
        for j in 0..nums.len() {
            if i32::abs((i - j) as i32) >= index_difference
                && i32::abs(nums[i] - nums[j]) >= value_difference
            {
                return vec![i as i32, j as i32];
            }
        }
    }
    vec![-1, -2]
}

pub fn minimum_sum(nums: Vec<i32>) -> i32 {
    let n = nums.len();
    if n < 3 {
        return -1;
    }
    let mut left_min = vec![0; n];
    let mut right_min = vec![0; n];
    left_min[0] = i32::MAX;
    right_min[n - 1] = i32::MIN;

    for i in 1..n {
        left_min[i] = i32::min(left_min[i - 1], nums[i - 1]);
    }
    for i in (0..=(n - 2)).rev() {
        right_min[i] = i32::min(right_min[i + 1], nums[i + 1]);
    }

    let mut min_sum = i32::MAX;
    for i in 1..(n - 1) {
        if left_min[i] < nums[i] && nums[i] > right_min[i] {
            min_sum = i32::min(min_sum, left_min[i] + nums[i] + right_min[i]);
        }
    }
    if min_sum == i32::MAX {
        -1
    } else {
        min_sum
    }
}



// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }

    pub fn build_from(vec: Vec<i32>) -> Option<Box<ListNode>> {
        let mut dummy = Box::new(ListNode::new(0));
        let mut current = &mut dummy;
        for i in vec {
            current.next = Some(Box::new(ListNode::new(i)));
            current = current.next.as_mut().unwrap();
        }
        dummy.next
    }

    pub fn show(list: &Option<Box<ListNode>>) {
        let mut cur = list;
        while let Some(node) = cur {
            print!("{} ", node.val);
            cur = &node.next;
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_string_sequence() {
        assert_eq!(string_sequence("abc".to_string()), ["aaa", "aa"]);
    }
}
