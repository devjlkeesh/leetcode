use std::cmp::Reverse;
use std::collections::{BinaryHeap, VecDeque};
use std::future::Future;

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
    if nums.len() == 1{
        return 1;
    }
    let mut c = 1;
    let mut max = 0;
    let mut prev = nums[0];
    for num in nums {
        if num > prev {
            c+=1
        }else{
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
            i+=1;
        }
    }
    i < bits.len()
}

pub fn search(nums: Vec<i32>, target: i32) -> i32 {
    let mut l = 0;
    let mut r = nums.len() - 1;
    while l <= r {
        let m = l + (r-l)/2;
        if nums[m] == target {
            return m as i32;
        }else if nums[m] > target {
            if m == 0 {
                return -1;
            }
            r = m - 1;
        }else{
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
    let mut dp = vec![0; cost.len()+2];
    for i in (0..=(cost.len()-1)).rev(){
        dp[i] = cost[i] + i32::min(dp[i+1],dp[i+2]);
    }
    i32::min(dp[0],dp[1])
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_string_sequence() {
        assert_eq!(string_sequence("abc".to_string()), ["aaa", "aa"]);
    }
}
