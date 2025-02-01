use std::cmp::Reverse;
use std::collections::{BinaryHeap, HashMap, HashSet};
use std::ops::Add;
use std::path::Component::ParentDir;
use std::str::Chars;
use std::vec;

pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut map: HashMap<i32, usize> = HashMap::with_capacity(nums.len());
    for i in 0..nums.len() {
        if let Some(j) = map.get(&(target - nums[i])) {
            return vec![*j as i32, i as i32];
        } else {
            map.insert(nums[i], i);
        }
    }
    vec![]
}

pub fn palindrome(x: i32) -> bool {
    if x < 0 {
        return false;
    }
    let mut temp = x;
    let mut reverse = 0;
    while temp > 0 {
        reverse = reverse * 10 + temp % 10;
        temp /= 10;
    }
    reverse == x
}

/**
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
*/
pub fn roman_to_int(s: String) -> i32 {
    let mut map: HashMap<char, i32> = HashMap::with_capacity(10);
    map.insert('I', 1);
    map.insert('V', 5);
    map.insert('X', 10);
    map.insert('L', 50);
    map.insert('C', 100);
    map.insert('D', 500);
    map.insert('M', 1000);

    let mut pre = 0;
    let mut total = 0;
    for x in s.chars().rev() {
        let int_val = *map.get(&x).unwrap();
        if int_val < pre {
            total = total - int_val;
            pre = int_val;
        } else {
            total = total + int_val;
            pre = int_val;
        }
    }
    total
}

pub fn longest_common_prefix(strs: Vec<String>) -> String {
    if strs.is_empty() {
        return String::from("");
    }
    if strs.len() == 1 {
        return strs[0].clone();
    }
    let mut result = String::new();
    let mut oi: usize = 0;

    let first_str = &strs[0];
    if first_str.is_empty() {
        return String::from("");
    }

    loop {
        if oi >= first_str.len() {
            break;
        }
        let curr_char = first_str.chars().nth(oi).unwrap();
        for curr_str in &strs[1..] {
            if oi >= curr_str.len() || curr_str.chars().nth(oi).unwrap() != curr_char {
                return result;
            }
        }
        result.push(curr_char);
        oi += 1;
    }
    result
}

pub fn is_valid_parentheses(s: String) -> bool {
    if s.len() <= 1 || s.len() % 2 != 0 {
        return false;
    }
    let mut stack: Vec<char> = Vec::with_capacity(s.len());
    for c in s.chars() {
        if stack.is_empty() {
            stack.push(c);
        } else {
            let c1 = *stack.last().unwrap();
            if c1 == '{' && c == '}' || c1 == '[' && c == ']' || c1 == '(' && c == ')' {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
    }
    stack.is_empty()
}

pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
    if nums.len() <= 1 {
        return nums.len() as i32;
    }
    let mut k: usize = 1;
    for i in 1..nums.len() {
        if nums[i] != nums[i - 1] {
            nums[k] = nums[i];
            k += 1;
        }
    }
    k as i32
}

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
}
pub fn merge_two_lists(
    list1: Option<Box<ListNode>>,
    list2: Option<Box<ListNode>>,
) -> Option<Box<ListNode>> {
    if list1.is_none() {
        return list2;
    }
    if list2.is_none() {
        return list1;
    }
    let mut head = Box::new(ListNode::new(0));
    let mut curr = &mut head;
    let mut l1 = list1;
    let mut l2 = list2;

    while l1.is_some() && l2.is_some() {
        if l1.as_ref()?.val < l2.as_ref()?.val {
            curr.next = l1.take();
            curr = curr.next.as_mut().unwrap();
            l1 = curr.next.take();
        } else {
            curr.next = l2.take();
            curr = curr.next.as_mut().unwrap();
            l2 = curr.next.take();
        }
    }
    while l1.is_some() {
        curr.next = l1.take();
        curr = curr.next.as_mut().unwrap();
        l1 = curr.next.take();
    }
    while l2.is_some() {
        curr.next = l2.take();
        curr = curr.next.as_mut().unwrap();
        l2 = curr.next.take();
    }
    head.next
}

pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {
    if nums.is_empty() {
        return 0;
    }
    let mut k = 0;
    for i in 0..nums.len() {
        if nums[i] != val {
            nums[k] = nums[i];
            k += 1;
        }
    }
    k as i32
}

pub fn str_str(haystack: String, needle: String) -> i32 {
    if haystack.len() < needle.len() {
        return -1;
    }
    let needle_len = needle.len();
    for i in 0..=(haystack.len() - needle_len) {
        if haystack[i..(i + needle_len)].to_string() == needle.to_string() {
            return i as i32;
        }
    }
    -1
}

pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
    if nums.is_empty() {
        return 0;
    }
    let mut first: usize = 0;
    let mut last: usize = nums.len();
    while first < last {
        let mid = first + (last - first) / 2;
        if nums[mid] == target {
            return mid as i32;
        } else if nums[mid] < target {
            first = mid + 1;
        } else {
            last = mid;
        }
    }
    last as i32
}

pub fn length_of_last_word(s: String) -> i32 {
    if s.is_empty() {
        return 0;
    }
    let mut s_len = s.len();
    let mut count: i32 = 0;
    let mut first_non_whitespace_encountered = false;
    while s_len > 0 {
        let ch = s.chars().nth(s_len - 1).unwrap();
        if ch == ' ' && first_non_whitespace_encountered {
            return count;
        }
        if ch != ' ' {
            first_non_whitespace_encountered = true;
            count += 1;
        }
        s_len -= 1;
    }
    count
}

pub fn plus_one(mut digits: Vec<i32>) -> Vec<i32> {
    for i in (0..digits.len()).rev() {
        if digits[i] < 9 {
            digits[i] += 1;
            return digits;
        }
        digits[i] = 0;
    }
    digits.insert(0, 1);
    digits
}

pub fn add_binary(a: String, b: String) -> String {
    if a.is_empty() {
        return b;
    }
    if b.is_empty() {
        return a;
    }

    let mut result = String::new();
    let mut rem = 0;

    let a_chars: Vec<char> = a.chars().collect();
    let b_chars: Vec<char> = b.chars().collect();

    let al = a_chars.len();
    let bl = b_chars.len();
    let max_len = al.max(bl);

    for i in 0..max_len {
        let ac = if i < al {
            a_chars[al - 1 - i] as i32 - 48
        } else {
            0
        };
        let bc = if i < bl {
            b_chars[bl - 1 - i] as i32 - 48
        } else {
            0
        };

        let temp = ac + bc + rem;
        rem = temp / 2;
        result.push((temp % 2 + 48) as u8 as char);
    }

    if rem != 0 {
        result.push('1');
    }

    result.chars().rev().collect()
}

pub fn my_sqrt(x: i32) -> i32 {
    let x = x as i64;
    let mut left: i64 = 0;
    let mut right = x;
    while left <= right {
        let mid = left + (right - left) / 2;
        if mid * mid == x {
            return mid as i32;
        } else if mid * mid > x {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    right as i32
}

pub fn climb_stairs(n: i32) -> i32 {
    if n <= 3 {
        return n;
    }
    let mut nth1 = 2;
    let mut nth2 = 3;
    let mut n = n;
    while n > 3 {
        let temp = nth1 + nth2;
        nth1 = nth2;
        nth2 = temp;
        n -= 1;
    }
    nth2
}

pub fn delete_duplicates(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    // let mut head = head;
    // let mut current = &mut head;
    //
    // while let Some(ref mut node) = current {
    //     if let Some(ref mut next_node) = node.next {
    //         if node.val == next_node.val {
    //             node.next = next_node.next.take();
    //         } else {
    //             current = &mut node.next;
    //         }
    //     } else {
    //         break;
    //     }
    // }

    head
}

pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
    let mut i = m - 1;
    let mut j = n - 1;
    let mut k = m + n - 1;
    while i >= 0 && j >= 0 {
        if nums1[i as usize] > nums2[j as usize] {
            nums1[k as usize] = nums1[i as usize];
            i -= 1;
        } else {
            nums1[k as usize] = nums2[j as usize];

            j -= 1;
        }
        k -= 1;
    }
    while j >= 0 {
        nums1[k as usize] = nums2[j as usize];
        j -= 1;
        k -= 1;
    }
}

pub fn generate_pascal_triangle(num_rows: i32) -> Vec<Vec<i32>> {
    if num_rows == 0 {
        return vec![];
    }
    if num_rows <= 1 {
        return vec![vec![1]];
    }
    let mut result = vec![vec![1]];

    for i in 1..(num_rows as usize) {
        let mut row = vec![1];
        let prev_row = &result[i - 1];
        for j in 1..i {
            row.push(prev_row[j - 1] + prev_row[j]);
        }
        row.push(1);
        result.push(row);
    }
    result
}
pub fn generate_pascal_triangle_nth_row(row_index: i32) -> Vec<i32> {
    if row_index == 0 {
        return vec![1];
    }
    if row_index <= 1 {
        return vec![1, 1];
    }
    let mut prev_row = vec![1, 1];
    for i in 2..=(row_index as usize) {
        let mut row = vec![1];
        for j in 1..i {
            row.push(prev_row[j - 1] + prev_row[j]);
        }
        row.push(1);
        prev_row = row;
    }
    prev_row
}

pub fn convert_to_title(mut column_number: i32) -> String {
    let mut title = String::new();
    while column_number > 0 {
        column_number -= 1;
        title.push(((column_number % 26) as u8 + 65u8) as char);
        column_number /= 26;
    }
    title.chars().rev().collect()
}

pub fn title_to_number(column_title: String) -> i32 {
    /* if column_title.len() == 1 {
        return column_title.chars().nth(0).unwrap() as i32 - 64;
    }
    let mut index = column_title.len() as i32 - 1;
    let mut result = 0;
    column_title.chars().for_each(|c| {
       let item = c as i32 - 64;
        result += item * 26i32.pow(index as u32);
        index -= 1;
    });
    result*/
    column_title
        .chars()
        .rev()
        .enumerate()
        .map(|(i, c)| (c as i32 - 64) * 26i32.pow(i as u32))
        .sum()
}

pub fn is_happy(mut n: i32) -> bool {
    let mut map = HashSet::new();

    fn digit_sum(mut n: i32) -> i32 {
        let mut sum = 0;
        while n > 0 {
            let remainder = n % 10;
            sum += remainder * remainder;
            n = n / 10;
        }
        sum
    }

    while n != 1 {
        if !map.insert(n) {
            return false;
        }
        n = digit_sum(n);
    }
    true
}

pub fn add_digits(mut num: i32) -> i32 {
    if num < 10 {
        return num;
    }
    let mut sum = 0;
    while num > 0 {
        sum += num % 10;
        num /= 10;
    }
    add_digits(sum)
}
pub fn add_digits2(mut num: i32) -> i32 {
    if num == 0 {
        return 0;
    }
    if num % 9 == 0 {
        return 9;
    }
    num % 9
}

pub fn is_ugly(mut n: i32) -> bool {
    if n <= 0 {
        return false;
    }
    while n % 2 == 0 {
        n /= 2;
    }
    while n % 3 == 0 {
        n /= 3;
    }
    while n % 5 == 0 {
        n /= 5;
    }
    n == 1
}

pub fn missing_number(nums: Vec<i32>) -> i32 {
    let n = nums.len() as i32;
    let expected = (n + 1) * (n + 0) / 2;
    let actual = nums.iter().sum::<i32>();
    expected - actual
}

pub fn can_win_nim(n: i32) -> bool {
    true
}

pub fn is_power_of_three(mut n: i32) -> bool {
    if n <= 0 {
        return false;
    }
    while n % 3 == 0 {
        n /= 3;
    }
    n == 1 || n == -1
}

pub fn is_power_of_four(mut n: i32) -> bool {
    if n <= 0 {
        return false;
    }
    while n % 4 == 0 {
        n /= 4;
    }
    n == 1 || n == -1
}

pub fn is_perfect_square(num: i32) -> bool {
    let num = num as i64;
    let mut left = 1;
    let mut right = num;
    while left <= right {
        let mut mid = left + (right - left) / 2;
        if mid * mid == num {
            return true;
        } else if mid * mid > num {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    false
}

pub fn to_hex(num: i32) -> String {
    if num == 0 {
        return "0".to_string();
    }
    let mut num = num as u32;
    let hex_vector = "0123456789abcdef".chars().collect::<Vec<char>>();
    let mut result = String::new();
    while num > 0 {
        let hex_char_index = (num % 16) as usize;
        result.push(hex_vector[hex_char_index]);
        num /= 16;
    }
    result.chars().rev().collect()
}

pub fn fizz_buzz(n: i32) -> Vec<String> {
    let mut result = vec![];
    for i in 1..=n {
        if i % 3 == 0 && i % 5 == 0 {
            result.push("FizzBuzz".to_string());
        } else if i % 3 == 0 {
            result.push("Fizz".to_string());
        } else if i % 5 == 0 {
            result.push("Buzz".to_string());
        } else {
            result.push(i.to_string());
        }
    }
    result
}

pub fn add_strings(num1: String, num2: String) -> String {
    if num1 == "0" {
        return num2;
    } else if num2 == "0" {
        return num1;
    }
    let mut n = num1.len() as i32 - 1;
    let mut m = num2.len() as i32 - 1;
    let num1_chars = num1.chars().map(|c| c as u8 - b'0').collect::<Vec<_>>();
    let num2_chars = num2.chars().map(|c| c as u8 - b'0').collect::<Vec<_>>();

    let mut result = String::new();
    let mut rem = 0;

    while n >= 0 || m >= 0 || rem > 0 {
        let i = if n >= 0 { num1_chars[n as usize] } else { 0 };
        let j = if m >= 0 { num2_chars[m as usize] } else { 0 };
        let sum = i + j + rem;
        result.push((b'0' + (sum % 10)) as char);
        rem = sum / 10;
        n -= 1;
        m -= 1;
    }
    result.chars().rev().collect()
}

pub fn arrange_coins(n: i32) -> i32 {
    let k = ((1 + 8 * n) as f64).sqrt() - 1.0;
    let k = (k / 2.0).floor() as i32;
    if k * (k + 1) / 2 <= n {
        k
    } else {
        k - 1
    }
}

pub fn construct_rectangle(area: i32) -> Vec<i32> {
    let mut w = (area as f64).sqrt() as i32;
    while area % w != 0 {
        w -= 1;
    }
    let l = area / w;
    vec![l, w]
}

pub fn convert_to_base7(mut num: i32) -> String {
    if num == 0 {
        return "0".to_string();
    }
    let mut result = String::new();
    let mut negative = false;
    if num < 0 {
        num *= -1;
        negative = true
    }
    while num > 0 {
        result.push((48u8 + (num % 7) as u8) as char);
        num /= 7;
    }
    if negative {
        result.push('-');
    }
    result.chars().rev().collect()
}

pub fn check_perfect_number(num: i32) -> bool {
    if num <= 1 {
        return false;
    }
    let mut divisors_sum = 1;
    let sqrt_num = (num as f64).sqrt() as i32;
    for i in 2..=sqrt_num {
        if num % i == 0 {
            divisors_sum += i;
            if i != num / i {
                divisors_sum += num / i;
            }
        }
    }

    divisors_sum == num
}

pub fn fib(n: i32) -> i32 {
    if n <= 1 {
        return n;
    }
    let mut fib0 = 0;
    let mut fib1 = 1;
    for i in 2..=n {
        let temp = fib1;
        fib1 = fib0 + fib1;
        fib0 = temp;
    }
    fib1
}

pub fn maximum_product(nums: Vec<i32>) -> i32 {
    let mut m1 = i32::MIN;
    let mut m2 = i32::MIN;
    let mut m3 = i32::MIN;
    let mut n1 = i32::MAX;
    let mut n2 = i32::MAX;

    for &num in &nums {
        if num > m1 {
            m3 = m2;
            m2 = m1;
            m1 = num;
        } else if num > m2 {
            m3 = m2;
            m2 = num;
        } else if num > m3 {
            m3 = num;
        }
        if num < n1 {
            n2 = n1;
            n1 = num;
        } else if num < n2 {
            n2 = num;
        }
    }

    let p1 = m1 * m2 * m3;
    let p2 = m1 * n1 * n2;
    p1.max(p2)
}

pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
    let mut result = vec![];
    'out: for i in left..=right {
        let mut num = i;
        while num > 0 {
            let digit = num % 10;
            if digit == 0 || i % digit != 0 {
                continue 'out;
            }
            num /= 10;
        }
        result.push(i);
    }
    result
}

pub fn count_prime_set_bits(mut left: i32, right: i32) -> i32 {
    let primes = [
        0, -1, 2, 3, -4, 5, -6, 7, -8, -9, -10, 11, -12, 13, -14, -15, -16, 17, -18, 19,
    ];
    let mut count = 0;
    while left <= right {
        let ones = left.count_ones();
        if primes[ones as usize] > 0 {
            count += 1;
        }
        left += 1;
    }
    count
}

// https://leetcode.com/problems/range-addition-ii/description/
pub fn max_count(m: i32, n: i32, ops: Vec<Vec<i32>>) -> i32 {
    if ops.is_empty() {
        return n * m;
    }
    let mut mr = ops[0][0];
    let mut mc = ops[0][1];
    for op in &ops {
        if op[0] < mr {
            mr = op[0];
        }
        if op[1] < mc {
            mc = op[1];
        }
    }
    mr * mc
}

// https://leetcode.com/problems/largest-triangle-area/
pub fn largest_triangle_area(points: Vec<Vec<i32>>) -> f64 {
    fn calculate_area(point1: &[i32], point2: &[i32], point3: &[i32]) -> f64 {
        f64::abs(
            0.5f64
                * ((point1[0] * (point2[1] - point3[1])
                + point2[0] * (point3[1] - point1[1])
                + point3[0] * (point1[1] - point2[1])) as f64),
        )
    }
    if points.len() == 3 {
        return calculate_area(&points[0], &points[1], &points[2]);
    }

    let mut area = 0.0;
    for i in 0..points.len() {
        for j in (i + 1)..points.len() {
            for k in (j + 1)..points.len() {
                area = f64::max(area, calculate_area(&points[i], &points[k], &points[j]));
            }
        }
    }
    area
}

// https://leetcode.com/problems/rectangle-overlap/
pub fn is_rectangle_overlap(rec1: Vec<i32>, rec2: Vec<i32>) -> bool {
    !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1] || rec1[1] >= rec2[3])
}

pub fn smallest_range_i(nums: Vec<i32>, k: i32) -> i32 {
    let mut min = i32::MAX;
    let mut max = i32::MIN;
    for x in nums {
        min = i32::min(min, x);
        max = i32::max(max, x);
    }
    i32::max(0, (max - k) - (min + k))
}

pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
    if deck.len() <= 1 {
        return false;
    }
    let mut map = HashMap::new();
    for x in deck {
        map.entry(x).and_modify(|v| *v += 1).or_insert(1);
    }
    let mut gcd = 0;
    fn get_gcd(mut a: i32, mut b: i32) -> i32 {
        while b != 0 {
            let temp = b;
            b = a % b;
            a = temp;
        }
        a
    }
    for (_, value) in map {
        gcd = get_gcd(gcd, value);
        if gcd == 1 {
            return false;
        }
    }
    gcd >= 2
}

pub fn max_sub_array_sum(nums: Vec<i32>) -> i32 {
    let mut max = 0;
    for i in 0..nums.len() {
        let mut sum = 0;
        for j in i..nums.len() {
            sum += nums[j];
            max = i32::max(max, sum)
        }
    }
    max
}

pub fn largest_perimeter(nums: Vec<i32>) -> i32 {
    let mut nums = nums;
    nums.sort();
    for i in (2..nums.len()).rev() {
        if nums[i - 2] + nums[i - 1] > nums[i] {
            return nums[i - 2] + nums[i - 1] + nums[i];
        }
    }
    0
}

pub fn add_to_array_form(mut num: Vec<i32>, mut k: i32) -> Vec<i32> {
    let mut carrier = 0;
    let mut i = num.len() as i32 - 1;
    let mut result = vec![];
    while i >= 0 || k > 0 || carrier > 0 {
        let mut sum = carrier;
        if i >= 0 {
            sum += num[i as usize];
            i -= 1;
        }
        if k > 0 {
            sum += k % 10;
            k /= 10;
        }
        result.push(sum % 10);
        carrier = sum / 10;
    }
    result.reverse();
    result
}

fn duplicate_zeros(arr: &mut Vec<i32>) {
    let mut zeros = 0;
    let arr_len = arr.len();
    for i in 0..arr_len {
        if arr[i] == 0 {
            zeros += 1;
        }
    }

    let mut nrr = vec![0; zeros + arr_len];
    let (mut i, mut j) = (0, 0);
    while i < arr.len() {
        if arr[i] != 0 {
            nrr[j] = arr[i];
        } else {
            j += 1;
        }
        j += 1;
        i += 1;
    }
    for i in 0..arr_len {
        arr[i] = nrr[i];
    }
}

pub fn height_checker(heights: Vec<i32>) -> i32 {
    let mut expected = heights.clone();
    expected.sort();
    let mut k = 0;
    for i in 0..heights.len() {
        if expected[i] != heights[i] {
            k += 1;
        }
    }
    k
}

pub fn check_if_exist(arr: Vec<i32>) -> bool {
    let mut v: Vec<i32> = vec![];
    for num in arr {
        if v.contains(&(num * 2)) || (num % 2 == 0 && v.contains(&(num / 2))) {
            return true;
        }
        v.push(num);
    }
    false
}

pub fn all_cells_dist_order(rows: i32, cols: i32, r_center: i32, c_center: i32) -> Vec<Vec<i32>> {
    let mut coords = vec![];
    for i in 0..rows {
        let r_distance = i32::abs(i - r_center);
        for j in 0..cols {
            coords.push(vec![r_distance + i32::abs(j - c_center), i, j]);
        }
    }
    coords.sort_by(|a, b| a[0].partial_cmp(&b[0]).unwrap());
    let mut result: Vec<Vec<i32>> = vec![];
    for x in coords {
        result.push(vec![x[1], x[2]]);
    }
    result
}

pub fn sort_colors(nums: &mut Vec<i32>) {
    let mut r = 0;
    let mut b = 0;
    let mut g = 0;
    for i in 0..nums.len() {
        if nums[i] == 0 {
            r += 1;
        } else if nums[i] == 1 {
            b += 1;
        } else {
            g += 1;
        }
    }
    for i in 0..nums.len() {
        if r > 0 {
            nums[i] = 0;
            r -= 1;
        } else if b > 0 {
            nums[i] = 1;
            b -= 1;
        } else if g > 0 {
            nums[i] = 2;
            g -= 1;
        }
    }
}

pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
    let mut result = vec![0; num_people as usize];
    let mut i: i32 = 0;
    let mut candies = candies;

    while candies > 0 {
        result[(i % num_people) as usize] += i32::min(i + 1, candies);
        candies -= i + 1;
        i += 1;
    }
    result
}

pub fn string_matching(words: Vec<String>) -> Vec<String> {
    let mut words = words;
    let mut result = vec![];
    words.sort_by(|s1, s2| s1.len().cmp(&s2.len()));
    for i in 0..words.len() {
        for j in (i + 1)..words.len() {
            if words[j].contains(&words[i]) {
                result.push(words[i].clone());
                break;
            }
        }
    }
    result
}

pub fn count_prefix_suffix_pairs(words: Vec<String>) -> i32 {
    if words.len() == 1 {
        return 0;
    }
    let mut counter = 0;
    for i in 0..(words.len() - 1) {
        for j in (i + 1)..words.len() {
            if words[j].starts_with(&words[i]) && words[j].ends_with(&words[i]) {
                counter += 1;
            }
        }
    }

    counter
}

pub fn day_of_year(date: String) -> i32 {
    let year = date[0..4].parse::<i32>().unwrap();
    let month = date[5..7].parse::<i32>().unwrap();
    let mut day = date[8..10].parse::<i32>().unwrap();
    let days = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365];
    if month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) {
        day += 1;
    }
    days[month as usize - 1] + day
}

pub fn min_increment_for_unique(nums: Vec<i32>) -> i32 {
    if nums.len() <= 1 {
        return 0;
    }
    let mut nums = nums;
    nums.sort();
    println!("nums: {:?}", nums);
    let mut inc = 0;
    let mut prev = nums[0];
    for i in 1..(nums.len()) {
        println!("nums: {:?}", nums[i]);
        if nums[i] == prev {
            inc += prev + 1 - nums[i];
            prev = prev + 1;
        } else {
            prev = nums[i];
        }
    }
    inc
}

pub fn is_palindrome(s: String) -> bool {
    let mut i = 0;
    let mut j = s.len() - 1;
    let chrs = s.chars().collect::<Vec<char>>();
    while i < j {
        let mut lc = chrs[i];
        if !((lc >= 'A' && lc <= 'Z') || (lc >= 'a' && lc <= 'z') || (lc >= '0' && lc <= '9')) {
            i += 1;
            continue;
        }
        let mut rc = chrs[j];
        if (!((rc >= 'A' && rc <= 'Z') || (rc >= 'a' && rc <= 'z') || (rc >= '0' && rc <= '9'))) {
            j -= 1;
            continue;
        }
        if (lc >= 'a') {
            lc = (lc as u8 - 32) as char;
        }
        if (rc >= 'a') {
            rc = (rc as u8 - 32) as char;
        }
        if (lc != rc) {
            return false;
        }
        i += 1;
        j -= 1;
    }
    true
}

pub fn reverse_string(s: &mut Vec<char>) {
    let mut i = 0;
    let mut j = s.len() - 1;
    while i < j {
        s.swap(i, j);
        i += 1;
        j -= 1;
    }
}

pub fn can_construct(ransom_note: String, magazine: String) -> bool {
    if ransom_note.len() > magazine.len() {
        return false;
    }
    let mut map = HashMap::new();
    let iter = magazine.chars();
    for letter in iter {
        let value = map.get(&letter).or(Some(&0)).unwrap();
        map.insert(letter, *value + 1);
    }
    let iter = ransom_note.chars();
    for letter in iter {
        let value = map.get(&letter).or(Some(&0)).unwrap();
        if *value == 0 {
            return false;
        }
        map.insert(letter, *value - 1);
    }
    true
}

pub fn count_segments(s: String) -> i32 {
    if s.is_empty() {
        return 0;
    }
    let mut p = ' ';
    let mut r = 0;
    let chars = s.chars();
    for ch in chars {
        if ch == ' ' && p == ' ' {
            r += 1;
        }
        p = ch;
    }

    if s.chars().nth(s.len() - 1).unwrap() == ' ' {
        r
    } else {
        r + 1
    }
}

pub fn contains_duplicate(nums: Vec<i32>) -> bool {
    let mut set = HashSet::new();
    for num in nums {
        if set.contains(&num) {
            return true;
        }
        set.insert(num);
    }
    false
}

pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
    let mut map = HashMap::new();
    let k = k as usize;
    for i in 1..nums.len() {
        let e = map.get(&nums[i]);
        if e.is_some() && i - e.unwrap() <= k {
            return true;
        }
        map.insert(nums[i], i);
    }
    false
}

pub fn check_straight_line(coordinates: Vec<Vec<i32>>) -> bool {
    if (coordinates.len() == 2) {
        return true;
    }
    let x1 = coordinates[0][0];
    let y1 = coordinates[0][1];
    let x2 = coordinates[1][0];
    let y2 = coordinates[1][1];
    for i in 2..coordinates.len() {
        let x3 = coordinates[i][0];
        let y3 = coordinates[i][1];
        let area = 0.5f64 * f64::abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) as f64);
        if (area > 0.0) {
            return false;
        }
    }
    true
}

pub fn odd_cells(m: i32, n: i32, indices: Vec<Vec<i32>>) -> i32 {
    let mut rows = vec![0; m as usize];
    let mut cols = vec![0; n as usize];

    for pair in indices {
        rows[pair[0] as usize] += 1;
        cols[pair[1] as usize] += 1;
    }

    let mut sum = 0;
    for i in 0..m as usize {
        for j in 0..n as usize {
            if (rows[i] + cols[j]) % 2 != 0 {
                sum += 1;
            }
        }
    }
    sum
}

pub fn can_alice_win(mut n: i32) -> bool {
    if n < 10 {
        return false;
    }
    let mut prev = 10;
    let mut i = 0;
    let mut alice_win = true;
    while n >= prev {
        n -= prev;
        prev -= 1;
        if i % 2 == 0 {
            alice_win = true;
        } else {
            alice_win = false;
        }
        i += 1;
    }

    alice_win
}

pub fn smallest_number(mut n: i32, t: i32) -> i32 {
    while n < i32::MAX {
        let mut a = n;
        let mut p = 1;
        while a > 0 {
            let d = a % 10;
            if d == 0 {
                p = 0;
                break;
            }
            p *= d;
            a /= 10;
        }
        if p % t == 0 {
            return n;
        }
        n += 1;
    }
    n
}

pub fn kth_character(k: i32) -> char {
    let mut chars = vec!['A'];
    while chars.len() < k as usize {
        let len = chars.len();
        for i in 0..len {
            chars.push(((chars[i] as u8 - 96) % 26 + 97) as char);
        }
    }
    chars[k as usize - 1]
}

pub fn get_sneaky_numbers(nums: Vec<i32>) -> Vec<i32> {
    let mut set = HashSet::new();
    let mut result = Vec::new();
    let mut i = 0;
    for num in nums {
        if set.contains(&num) {
            result.push(num);
            i += 1;
            if i == 2 {
                break;
            }
        } else {
            set.insert(num);
        }
    }
    result
}

pub fn convert_date_to_binary(date: String) -> String {
    let year = &date[0..4];
    let month = &date[5..7];
    let day = &date[8..10];

    let year_binary = format!("{:b}", year.parse::<u32>().unwrap());
    let month_binary = format!("{:b}", month.parse::<u32>().unwrap());
    let day_binary = format!("{:b}", day.parse::<u32>().unwrap());

    format!("{}-{}-{}", year_binary, month_binary, day_binary)
}

pub fn num_prime_arrangements(n: i32) -> i32 {
    let m = 1000007;
    let count_primes = |n: i32| -> i32 {
        let n = n as usize;
        let mut primes = vec![true; n + 1];
        primes[0] = false;
        primes[1] = false;
        for i in 2..=n {
            for j in ((i * i)..=n).step_by(i) {
                primes[j] = false;
            }
        }
        let mut count = 0;
        for i in 1..=n {
            if primes[i] {
                count += 1;
            }
        }
        count
    };

    let fac = |n: i32| -> i64 {
        let mut r = 1;
        for i in 2..=n {
            r = (r * i as i64) % m;
        }
        r
    };

    let pc = count_primes(n);
    let cc = n - pc;
    (fac(pc) * fac(cc) % m) as i32
}

pub fn day_of_the_week(day: i32, month: i32, year: i32) -> String {
    let mut days = (year - 1971) * 365;
    for i in 1971..year {
        if i % 4 == 0 && (i % 100 != 0 || i % 400 == 0) {
            days += 1;
        }
    }

    let month_days = vec![0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365];
    let mut day_of_year = month_days[month as usize - 1] + day;
    if (month >= 3 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
        day_of_year += 1;
    }
    days += day_of_year;
    let day_of_week = vec![
        "Friday",
        "Saturday",
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
    ];
    day_of_week[(days as usize - 1) % 7].to_string()
}

pub fn prefix_count(words: Vec<String>, pref: String) -> i32 {
    if pref.is_empty() {
        return words.len() as i32;
    }
    let mut count = 0;
    for w in words {
        if w.starts_with(&pref) {
            count += 1;
        }
    }
    count
}

pub fn gcd_of_strings(str1: String, str2: String) -> String {
    if str1.clone() + &str2 != str2.clone() + &str1 {
        return String::new();
    }
    let mut a = str1.len();
    let mut b = str2.len();
    while b != 0 {
        let temp = a;
        a = b;
        b = temp % b;
    }
    str1[..a].to_string()
}

pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
    if nums1.len() == 0 || nums2.len() == 0 {
        return vec![];
    }

    let mut m = vec![0; 1001];
    for n in nums1 {
        m[n as usize] = 1;
    }
    let mut count = 0;
    for n in nums2 {
        if m[n as usize] == 1 {
            m[n as usize] = 2;
            count += 1;
        }
    }
    let mut result = vec![0i32; count];
    let mut j = 0;
    for i in 0..m.len() {
        if m[i] == 2 {
            result[j] = i as i32;
            j += 1;
        }
    }
    result
}

pub fn sum_of_encrypted_int(nums: Vec<i32>) -> i32 {
    let mut s = 0;
    for mut num in nums {
        let mut max_digit = 0;
        let mut digit_count = 0;
        while num > 0 {
            max_digit = i32::max(max_digit, num % 10);
            num /= 10;
            digit_count += 1;
        }
        let mut i = 1;
        while digit_count > 0 {
            s += max_digit * i;
            digit_count -= 1;
            i *= 10;
        }
    }
    s
}

pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
    let mut index_map = HashMap::new();

    for (i, &ref item) in list1.iter().enumerate() {
        index_map.insert(item, i);
    }

    let mut result = Vec::new();
    let mut min_sum = usize::MAX;

    for (j, &ref item) in list2.iter().enumerate() {
        if let Some(&i) = index_map.get(&item) {
            let sum = i + j;
            if sum < min_sum {
                result.clear();
                result.push(item.to_string());
                min_sum = sum;
            } else if sum == min_sum {
                result.push(item.to_string());
            }
        }
    }

    result
}

pub fn first_uniq_char(s: String) -> i32 {
    let mut map = [0; 26];
    s.chars().for_each(|c| {
        map[c as usize - 'a' as usize] += 1;
    });
    for (i, c) in s.chars().enumerate() {
        if map[c as usize - 'a' as usize] == 1 {
            return i as i32;
        }
    }
    -1
}

pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
    let mut m = [0; 1001];
    for n in &nums1 {
        m[*n as usize] += 1;
    }

    let mut i = 0;
    let mut r = vec![0; nums1.len()];
    for n in nums2 {
        if m[n as usize] > 0 {
            r[i] = n;
            m[n as usize] -= 1;
            i += 1;
        }
    }
    r[..i].to_vec()
}

pub fn find_disappeared_numbers(nums: Vec<i32>) -> Vec<i32> {
    let mut m = vec![0; nums.len() + 1];
    for n in nums {
        m[n as usize] += 1;
    }
    let mut r = vec![];
    for i in 0..m.len() {
        if m[i] == 0 {
            r.push(i as i32);
        }
    }
    r
}

pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
    let mut map: HashMap<String, Vec<String>> = HashMap::new();
    for s in strs {
        let mut chars: Vec<char> = s.chars().collect();
        chars.sort_unstable();
        let key: String = chars.into_iter().collect();

        map.entry(key).or_insert_with(Vec::new).push(s);
    }

    map.into_values().collect()
}

pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
    let mut row = vec![HashSet::new(); 9];
    let mut col = vec![HashSet::new(); 9];
    let mut grid = vec![HashSet::new(); 9];
    for i in 0..9 {
        for j in 0..9 {
            let ch = board[i][j];
            if ch == '.' {
                continue;
            }
            let gi = (i * 3) / 3 + j / 3;
            if row[i].contains(&ch) || col[j].contains(&ch) || grid[i].contains(&ch) {
                return false;
            }
            row[i].insert(ch);
            col[j].insert(ch);
            grid[gi].insert(ch);
        }
    }
    true
}

pub fn num_jewels_in_stones(jewels: String, stones: String) -> i32 {
    let mut ch = [0; 128];
    let mut n = 0;
    stones.chars().for_each(|c| {
        ch[c as usize] += 1;
    });
    jewels.chars().for_each(|c| {
        n += ch[c as usize];
    });
    n
}

pub fn four_sum_count(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>, nums4: Vec<i32>) -> i32 {
    let mut count = 0;
    let mut map = HashMap::new();
    for a in nums1 {
        for b in &nums2 {
            let ab = a + b;
            map.insert(ab, map.get(&ab).unwrap_or(&0) + 1);
        }
    }
    for c in nums3 {
        for d in &nums4 {
            let cd = -(c + d);
            count += map.get(&cd).unwrap_or(&0);
        }
    }
    count
}

pub fn check_two_chessboards(coordinate1: String, coordinate2: String) -> bool {
    let mut p1 = vec![];
    let mut p2 = vec![];
    coordinate1.chars().for_each(|c| {
        p1.push(c as i32);
    });
    coordinate2.chars().for_each(|c| {
        p2.push(c as i32);
    });
    if (p1[0] + p1[1]) % 2 == 0 && (p2[0] + p2[1]) % 2 == 0 {
        return true;
    }
    (p1[0] + p1[1]) % 2 != 0 && (p2[0] + p2[1]) % 2 != 0
}

pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut map = HashMap::new();
    let mut result = Vec::with_capacity(k as usize);

    for &num in &nums {
        *map.entry(num).or_insert(0) += 1;
    }
    let mut pq = BinaryHeap::new();
    for (&key, &val) in &map {
        pq.push(Reverse((val, key)));
        if pq.len() > k as usize {
            pq.pop();
        }
    }
    while let Some(Reverse((_, key))) = pq.pop() {
        result.push(key);
    }
    result.reverse();
    result
}

pub fn get_final_state(nums: Vec<i32>, k: i32, multiplier: i32) -> Vec<i32> {
    let mut nums = nums;
    for i in 0..k {
        let mut min = i32::MAX;
        let mut min_index = 0;
        for j in 0..nums.len() {
            if nums[j] < min {
                min = nums[j];
                min_index = j;
            }
        }
        nums[min_index] = min * multiplier;
    }
    nums
}

pub fn can_alice_win2(nums: Vec<i32>) -> bool {
    let mut single_digit_sum = 0;
    let mut double_digit_sum = 0;
    for num in &nums {
        if *num < 10 {
            single_digit_sum += num;
        } else {
            double_digit_sum += num;
        }
    }
    single_digit_sum != double_digit_sum
}

pub fn winning_player(x: i32, y: i32) -> String {
    let mut x = x;
    let mut y = y;
    let mut alice_turn = false;
    while x > 0 && y > 3 {
        x -= 1;
        y -= 4;
        alice_turn = !alice_turn;
    }
    if alice_turn {
        String::from("Alice")
    } else {
        String::from("Bob")
    }
}

pub fn minimum_operations(nums: Vec<i32>) -> i32 {
    let mut count = 0;
    for num in nums {
        if num % 3 != 0 {
            count += 1;
        }
    }
    count
}
pub fn number_of_child(n: i32, k: i32) -> i32 {
    if k < n {
        return k;
    }
    let mut left_to_right = true;
    let mut k = k;
    while k >= n {
        left_to_right = !left_to_right;
        k -= n - 1;
    }
    if left_to_right {
        k
    } else {
        n - k - 1
    }
}

pub fn triangle_type(nums: Vec<i32>) -> String {
    let a = nums[0];
    let b = nums[1];
    let c = nums[2];
    if a == b && b == c {
        return String::from("equilateral");
    }
    if a + b < c || a + c < b || b + c < a {
        return String::from("none");
    }
    if a == b || a == c || b == c {
        return String::from("isosceles");
    }
    String::from("scalene")
}

pub fn find_missing_and_repeated_values(grid: Vec<Vec<i32>>) -> Vec<i32> {
    let n = grid.len() as i32;
    let need_sum = n * n * (1 + n * n) / 2;
    let mut actual_sum = 0;
    let mut map = vec![0; (n * n + 1) as usize];
    let mut dublicate = 0;
    for row in grid {
        for cell in row {
            if map[cell as usize] != 0 {
                dublicate = cell;
            } else {
                map[cell as usize] += 1;
            }
            actual_sum += cell;
        }
    }
    vec![dublicate, need_sum + dublicate - actual_sum]
}

pub fn are_similar(mat: Vec<Vec<i32>>, k: i32) -> bool {
    let n = mat.len();
    let m = mat[0].len();
    let mut k = k as usize;
    k %= m;
    for i in 0..n {
        for j in 0..m {
            let new_index = if i % 2 == 0 {
                (j + k) % m
            } else {
                (j - k + m) % m
            };
            if mat[i][new_index] != mat[i][j] {
                return false;
            }
        }
    }
    true
}

pub fn maximum_odd_binary_number(s: String) -> String {
    let mut ones_count = 0;
    s.chars().for_each(|c| {
        if c == '1' {
            ones_count += 1;
        }
    });
    let zeroes_count = s.len() - ones_count;
    let mut result = String::with_capacity(s.len());

    for i in 0..(ones_count - 1) {
        result.push('1');
    }
    for i in 0..zeroes_count {
        result.push('0');
    }
    result.push('1');
    result
}

pub fn difference_of_sums(n: i32, m: i32) -> i32 {
    let actual_sum = n * (1 + n) / 2;
    let mut s = 0;
    for i in 1..=n {
        if i % m == 0 {
            s += i;
        }
    }
    actual_sum - 2 * s
}

pub fn count_symmetric_integers(low: i32, high: i32) -> i32 {
    let mut count = 0;
    for i in low..=high {
        let digit_count = i32::ilog10(i);
        if digit_count % 2 == 0 {
            let divisor = i32::pow(10, digit_count / 2);
            let mut first_half = i / divisor;
            let mut second_half = i % divisor;

            let mut first_half_digit_sum = 0;
            let mut second_half_digit_sum = 0;

            while first_half > 0 {
                first_half_digit_sum += first_half % 10;
                first_half /= 10;
            }

            while second_half > 0 {
                second_half_digit_sum += second_half % 10;
                second_half /= 10;
            }
            if (first_half_digit_sum == second_half_digit_sum) {
                count += 1;
            }
        }
    }
    count
}

pub fn summary_ranges(nums: Vec<i32>) -> Vec<String> {
    let mut result = vec![];
    if nums.is_empty() {
        return result;
    }
    let mut start = nums[0];
    for i in 1..=nums.len() {
        if i == nums.len() || nums[i - 1] + 1 != nums[i] {
            if start == nums[i - 1] {
                result.push(start.to_string());
            } else {
                result.push(format!("{}->{}", start, nums[i - 1]));
            }
            if i < nums.len() {
                start = nums[i];
            }
        }
    }
    result
}

struct NumArray {
    nums: Vec<i32>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl NumArray {
    fn new(nums: Vec<i32>) -> Self {
        let mut nums = nums;
        for i in 1..nums.len() {
            nums[i] = nums[i - 1] + nums[i];
        }
        Self { nums }
    }

    fn sum_range(&self, left: i32, right: i32) -> i32 {
        if left == 0 {
            return self.nums[right as usize];
        }
        self.nums[right as usize] - self.nums[left as usize - 1]
    }
}

pub fn distribute_candies2(candy_type: Vec<i32>) -> i32 {
    let mut ct = [false; 2 * 100_000 + 1];
    let mut type_count = 0;
    let n = candy_type.len();
    for t in candy_type {
        let t = (t + 100000) as usize;
        if !ct[t] {
            type_count += 1;
            if type_count == n / 2 {
                return type_count as i32;
            }
            ct[t] = true;
        }
    }
    type_count as i32
}

pub fn hamming_distance(x: i32, y: i32) -> i32 {
    (x ^ y).count_ones() as i32
}

pub fn valid_palindrome(s: String) -> bool {
    fn valid_palindrom(s: &Vec<char>, mut i: usize, mut j: usize, a: bool) -> bool {
        while i < j {
            if s[i] != s[j] {
                if a {
                    return false;
                }
                return valid_palindrom(s, i + 1, j, true) || valid_palindrom(s, i, j - 1, true);
            }
            i += 1;
            j -= 1;
        }
        true
    }
    let chars: Vec<char> = s.chars().collect();
    valid_palindrom(&chars, 0, s.len(), false)
}

pub fn final_position_of_snake(n: i32, commands: Vec<String>) -> i32 {
    let mut cr = 0;
    let mut cc = 0;
    for command in commands {
        if command.eq("UP") {
            cr -= 1;
        } else if (command.eq("DOWN")) {
            cr += 1;
        } else if (command.eq("LEFT")) {
            cc -= 1;
        } else {
            cc += 1;
        }
    }
    (cr * n) + cc
}

pub fn is_balanced(num: String) -> bool {
    let mut even_sum = 0;
    let mut odd_sum = 0;
    num.chars().enumerate().for_each(|(i, c)| {
        if i % 2 == 0 {
            even_sum += c as i32 - 48;
        } else {
            odd_sum += c as i32 - 48;
        }
    });
    even_sum == odd_sum
}

pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
    if start == goal {
        return 0;
    }
    let mut count = 0;
    let mut start = start;
    let mut goal = goal;
    let mut ir = start % 2;
    let mut jr = goal % 2;
    while start > 0 || goal > 0 {
        if ir != jr {
            count += 1;
        }
        start /= 2;
        goal /= 2;
        ir = start % 2;
        jr = goal % 2;
    }
    count
}

pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
    let mut ans = vec![-1; nums2.len()];
    for i in 0..nums1.len() {
        let mut id = 0;
        for j in 0..nums2.len() {
            if nums1[i] == nums2[j] {
                id = j;
                break;
            }
        }
        for j in (id + 1)..nums2.len() {
            if nums1[i] < nums2[j] {
                id = j;
                ans[i] = nums2[j];
                break;
            }
        }
    }
    ans
}

pub fn find_words(words: Vec<String>) -> Vec<String> {
    let row = [
        2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3,
    ];
    let mut result = Vec::new();
    for word in words {
        let mut row_number_count = 0;
        let mut row_number = 0;
        word.chars().for_each(|mut c| {
            let mut c = c as u8;
            if (c > 90) {
                c -= 32;
            }
            c -= 65;
            if (row_number != row[c as usize]) {
                row_number_count += 1;
                row_number = row[c as usize];
            }
        });
        if (row_number_count == 1) {
            result.push(word);
        }
    }
    result
}

pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
    let mut result = Vec::new();
    let mut min1 = i32::MAX;
    let mut min2 = i32::MAX;
    let mut min3 = i32::MAX;

    for i in 0..score.len() {
        if score[i] < min1 {
            min3 = min2;
            min2 = min1;
            min1 = score[i];
        } else if score[i] < min2 && score[i] > min1 {
            min3 = min2;
            min2 = score[i];
        } else if score[i] < min3 && score[i] > min2 {
            min3 = min2;
        }
    }
    let mut s = score.len();
    for x in score {
        if min1 == x {
            result.push(String::from("Gold Medal"));
        } else if min2 == x {
            result.push(String::from("Silver Medal"));
        } else if min3 == x {
            result.push(String::from("Bronze Medal"));
        } else {
            result.push(x.to_string());
        }
    }
    result
}

pub fn find_relative_ranks2(score: Vec<i32>) -> Vec<String> {
    let max = *score.iter().max().unwrap_or_else(|| &0);
    let mut p = vec![0; (max + 1) as usize];

    for (i, &s) in score.iter().enumerate() {
        p[s as usize] = i + 1;
    }

    let mut ans = vec![String::new(); score.len()];
    let mut rank = 1;

    for i in (0..=max).rev() {
        if p[i as usize] != 0 {
            let id = p[i as usize] - 1;
            ans[id] = match rank {
                1 => "Gold Medal".to_string(),
                2 => "Silver Medal".to_string(),
                3 => "Bronze Medal".to_string(),
                _ => rank.to_string(),
            };
            rank += 1;
            if rank > score.len() {
                return ans;
            }
        }
    }
    ans
}

pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
    if mat.len() * mat[0].len() != r as usize * c as usize {
        return mat;
    }
    let r = r as usize;
    let c = c as usize;
    let mut mi = 0;
    let mut mj = 0;
    let mc = mat[0].len();
    let mut res = vec![vec![0; c]; r];
    for i in 0..r {
        for j in 0..c {
            res[i][j] = mat[mi][mj];
            mj += 1;
            if mj >= mc {
                mi += 1;
                mj = 0;
            }
        }
    }
    res
}

pub fn find_lhs(nums: Vec<i32>) -> i32 {
    let mut nums = nums;
    let mut max = 0;
    let mut i = 0;
    nums.sort_unstable();
    for j in 0..nums.len() {
        while nums[j] - nums[i] > 1 {
            i += 1;
        }
        if nums[j] - nums[i] == 1 {
            max = i32::max(max, (j - i) as i32 + 1);
        }
    }
    max
}

pub fn find_error_nums(nums: Vec<i32>) -> Vec<i32> {
    let n = nums.len();
    let ns = n * (n + 1) / 2;
    let mut m = vec![0; ns];
    let mut d = 0;
    let mut t = 0;
    for num in nums {
        if m[num as usize] == 1 {
            d = num;
        }
        m[num as usize] += 1;
        t += num;
    }
    vec![d, ns as i32 - t + d]
}

pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
    let mut sum = 0;
    let k = k as usize;
    for i in 0..k {
        sum += nums[i];
    }
    let mut max = sum;
    for i in k..nums.len() {
        sum += nums[i] - nums[i - k];
        max = i32::max(max, sum);
    }
    (max as f64) / (k as f64)
}

pub fn dominant_index(nums: Vec<i32>) -> i32 {
    let mut m = [0; 101];
    let mut m1 = i32::MIN;
    let mut m2 = i32::MIN;
    for i in 0..nums.len() {
        let num = nums[i];
        if num > m1 {
            m2 = m1;
            m1 = num;
        } else if num > m2 && num < m1 {
            m2 = num;
        }
        m[num as usize] = i;
    }
    if 2 * m2 <= m1 {
        return m[m1 as usize] as i32;
    }
    -1
}

pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
    let mut m = [0; 26];
    license_plate.chars().enumerate().for_each(|(i, c)| {
        if c >= 'A' && c <= 'Z' {
            m[c as usize - 65] += 1;
        } else if c >= 'a' && c <= 'z' {
            m[c as usize - 97] += 1;
        }
    });
    fn compare(word: &String, m: &[i32; 26]) -> bool {
        let mut tm = [0; 26];
        word.chars().for_each(|c| {
            tm[c as usize - 97] += 1;
        });
        for i in 0..26 {
            if tm[i] < m[i] {
                return false;
            }
        }
        true
    }
    let mut idx = -1;
    for i in 0..words.len() {
        let word = &words[i];
        if compare(word, &m) && (idx == -1 || words[i].len() < words[idx as usize].len()) {
            idx = i as i32
        }
    }
    words[idx as usize].clone()
}

pub fn is_toeplitz_matrix(matrix: Vec<Vec<i32>>) -> bool {
    let m = matrix.len();
    let n = matrix[0].len();
    let mut i;
    let mut j;
    for c in 0..n {
        i = 0;
        j = c;
        let prev = matrix[i][j];
        while i < m && j < n {
            if prev != matrix[i][j] {
                return false;
            }
            i += 1;
            j += 1;
        }
    }
    for c in 1..m {
        i = c;
        j = 0;
        let prev = matrix[i][j];
        while i < m && j < n {
            if prev != matrix[i][j] {
                return false;
            }
            i += 1;
            j += 1;
        }
    }
    true
}

pub fn transpose(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let m = matrix.len();
    let n = matrix[0].len();
    let mut transpose = vec![vec![0; m]; n];
    for i in 0..m {
        for j in 0..n {
            transpose[i][j] = matrix[j][i];
        }
    }
    transpose
}


pub fn unique_morse_representations(words: Vec<String>) -> i32 {
    if words.len() <= 1 {
        return words.len() as i32;
    }
    let morse = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."];
    fn transform(word: &String, morse: &[&str;26]) -> String {
        let mut sb = String::with_capacity(word.len());
        word.chars().for_each(|c| {
            let a = morse[c  as usize - 97].clone();
            sb.push_str(a);
        });
        sb
    }
    let mut set = HashSet::new();

    for word in words {
        set.insert(transform(&word, &morse));
    }
    set.len() as i32

}

pub fn number_of_lines(widths: Vec<i32>, s: String) -> Vec<i32> {
    let mut l = 1;
    let mut cur = 0;
    s.chars().for_each(|c| {
        let w = widths[c as usize - 97];
        if cur + w > 100 {
            l += 1;
            cur = w;
        } else {
            cur += w;
        }
    });
    vec![l, cur]
}

pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
    let mut map = HashMap::new();
    let mut set: HashSet<_> = banned.into_iter().collect();
    let mut sb = String::new();
    paragraph.chars().for_each(|c| {
        if (c == ' ' || c == '!' || c == '?' || c == ',' || c == ';' || c == '.') && !sb.is_empty()
        {
            if !set.contains(&sb) {
                *map.entry(sb.clone()).or_insert(0) += 1;
            }
            sb = String::new();
        }
        if c.is_alphabetic() {
            sb.push(c.to_ascii_lowercase());
        }
    });

    if !sb.is_empty() && !set.contains(&sb) {
        *map.entry(sb.clone()).or_insert(0) += 1;
    }
    map.iter()
        .max_by_key(|e| e.1)
        .map(|e| e.0.clone())
        .unwrap()
        .clone()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn matrix_reshape() {
        assert_eq!(
            super::matrix_reshape(vec![vec![1, 2], vec![3, 4]], 1, 4),
            vec![vec![1, 2, 3, 4]]
        )
    }

    #[test]
    fn find_relative_ranks2() {
        let response = super::find_relative_ranks2(vec![5, 4, 3, 2, 1]);
        assert_eq!(
            response,
            vec![
                "Gold Medal".to_string(),
                "Silver Medal".to_string(),
                "Bronze Medal".to_string(),
                "4".to_string(),
                "5".to_string()
            ]
        );
    }

    #[test]
    fn first_uniq_char() {
        assert_eq!(super::first_uniq_char("leetcode".to_string()), 0);
    }

    #[test]
    fn gcd_of_strings() {
        assert_eq!(
            super::gcd_of_strings("ABABAB".to_string(), "ABAB".to_string()),
            "AB".to_string()
        )
    }

    #[test]
    fn day_of_the_week() {
        assert_eq!("Saturday", super::day_of_the_week(31, 8, 2019));
    }

    #[test]
    fn reverse_string() {
        let mut v = vec!['a', 'b', 'c', 'd'];
        let expected = vec!['d', 'c', 'b', 'a'];
        super::reverse_string(&mut v);
        assert_eq!(expected, v);
    }

    #[test]
    fn is_palindrome() {
        assert_eq!(true, super::is_palindrome("aba".to_string()));
    }
    #[test]
    fn two_sum() {
        assert_eq!(super::two_sum(vec![2, 7, 11, 15], 9), vec![0, 1]);
        assert_eq!(super::two_sum(vec![3, 2, 4], 6), vec![1, 2]);
    }

    #[test]
    fn palindrome() {
        assert_eq!(super::palindrome(121), true);
        assert_eq!(super::palindrome(12), false);
        assert_eq!(super::palindrome(-12), false);
    }

    #[test]
    fn roman_to_int() {
        assert_eq!(super::roman_to_int(String::from("III")), 3);
        assert_eq!(super::roman_to_int(String::from("IV")), 4);
        assert_eq!(super::roman_to_int(String::from("IX")), 9);
        assert_eq!(super::roman_to_int(String::from("LVIII")), 58);
        assert_eq!(super::roman_to_int(String::from("MCMXCIV")), 1994);
        assert_eq!(super::roman_to_int(String::from("MCMXCV")), 1995);
    }

    #[test]
    fn longest_common_prefix() {
        assert_eq!(
            super::longest_common_prefix(vec![String::from("")]),
            String::from("")
        );
        assert_eq!(
            super::longest_common_prefix(vec![String::from("III"), String::from("I")]),
            String::from("I")
        );
    }

    #[test]
    fn is_valid_parentheses() {
        assert_eq!(super::is_valid_parentheses(String::from("")), false);
        assert_eq!(super::is_valid_parentheses(String::from("{}")), true);
        assert_eq!(super::is_valid_parentheses(String::from("()[]{}")), true);
        assert_eq!(super::is_valid_parentheses(String::from("()[]}")), false);
        assert_eq!(super::is_valid_parentheses(String::from("(]")), false);
        assert_eq!(super::is_valid_parentheses(String::from("({[)")), false);
    }

    #[test]
    fn remove_duplicates() {
        assert_eq!(super::remove_duplicates(&mut vec![0, 0, 1, 2, 3, 4]), 5)
    }

    fn create_list(values: Vec<i32>) -> Option<Box<ListNode>> {
        let mut head = None;
        for &val in values.iter().rev() {
            let mut new_node = ListNode::new(val);
            new_node.next = head;
            head = Some(Box::new(new_node));
        }
        head
    }

    #[test]
    fn merge_two_sorted_lists_both_non_empty() {
        let list1 = create_list(vec![1, 3, 5]);
        let list2 = create_list(vec![2, 4, 6]);
        let result = super::merge_two_lists(list1, list2);
        let expected = create_list(vec![1, 2, 3, 4, 5, 6]);
        assert_eq!(result, expected);
    }

    #[test]
    fn merge_two_sorted_lists_one_empty() {
        let list1 = create_list(vec![1, 2, 3]);
        let list2: Option<Box<super::ListNode>> = None;
        let result = super::merge_two_lists(list1, list2);
        let expected = create_list(vec![1, 2, 3]);

        assert_eq!(result, expected);
    }

    #[test]
    fn merge_two_sorted_lists_both_empty() {
        let list1: Option<Box<super::ListNode>> = None;
        let list2: Option<Box<super::ListNode>> = None;
        let result = super::merge_two_lists(list1, list2);
        let expected: Option<Box<super::ListNode>> = None;

        assert_eq!(result, expected);
    }

    #[test]
    fn merge_two_sorted_lists_with_duplicates() {
        let list1 = create_list(vec![1, 2, 4]);
        let list2 = create_list(vec![1, 3, 4]);
        let result = super::merge_two_lists(list1, list2);
        let expected = create_list(vec![1, 1, 2, 3, 4, 4]);

        assert_eq!(result, expected);
    }

    #[test]
    fn remove_element() {
        assert_eq!(super::remove_element(&mut vec![1, 2, 1, 2], 2), 2)
    }

    #[test]
    fn str_str() {
        assert_eq!(
            super::str_str(String::from("saddffsad"), String::from("sad")),
            0
        );
        assert_eq!(
            super::str_str(String::from("saddffsad"), String::from("sada")),
            -1
        );
        assert_eq!(super::str_str(String::from("a"), String::from("a")), 0);
    }

    #[test]
    fn search_insert() {
        assert_eq!(super::search_insert(vec![1, 2, 3, 4, 5, 6, 7, 8, 9], 3), 2);
        assert_eq!(super::search_insert(vec![-32, 1, 12, 82], -32), 0);
        assert_eq!(super::search_insert(vec![1, 3, 5, 6], 2), 1);
        assert_eq!(super::search_insert(vec![3, 5, 6], 2), 0);
        assert_eq!(super::search_insert(vec![3, 5, 6], 4), 1);
        assert_eq!(super::search_insert(vec![3, 5, 7], 6), 2);
    }

    #[test]
    fn length_of_last_word() {
        assert_eq!(super::length_of_last_word(String::from("")), 0);
        assert_eq!(super::length_of_last_word(String::from("Hello World ")), 5);
    }

    #[test]
    fn plus_one() {
        assert_eq!(super::plus_one(vec![1, 2, 3]), vec![1, 2, 4]);
        assert_eq!(super::plus_one(vec![8]), vec![9]);
        assert_eq!(super::plus_one(vec![9]), vec![1, 0]);
    }

    #[test]
    fn my_sqrt() {
        assert_eq!(2, super::my_sqrt(4));
        assert_eq!(3, super::my_sqrt(9));
        assert_eq!(4, super::my_sqrt(16));
        assert_eq!(2, super::my_sqrt(8));
        assert_eq!(46339, super::my_sqrt(2147395599));
    }

    #[test]
    fn climb_stairs() {
        assert_eq!(1, super::climb_stairs(1));
        assert_eq!(2, super::climb_stairs(2));
        assert_eq!(3, super::climb_stairs(3));
        assert_eq!(5, super::climb_stairs(4));
    }

    #[test]
    fn add_binary() {
        assert_eq!(
            super::add_binary(String::from(""), String::from("1")),
            String::from("1")
        );
        assert_eq!(
            super::add_binary(String::from("1"), String::from("")),
            String::from("1")
        );
        assert_eq!(
            super::add_binary(String::from("111"), String::from("101")),
            String::from("1100")
        );
        assert_eq!(
            super::add_binary(String::from("1111"), String::from("1")),
            String::from("10000")
        );
        assert_eq!(
            super::add_binary(String::from("1010"), String::from("1011")),
            String::from("10101")
        );
    }

    // #[test]
    fn remove_duplicates_from_sorted_list() {
        // Input: 1 -> 1 -> 2
        let node3 = Some(Box::new(ListNode { val: 2, next: None }));
        let node2 = Some(Box::new(ListNode {
            val: 1,
            next: node3,
        }));
        let head = Some(Box::new(ListNode {
            val: 1,
            next: node2,
        }));

        let expected = Some(Box::new(ListNode {
            val: 1,
            next: Some(Box::new(ListNode { val: 2, next: None })),
        }));

        assert_eq!(expected, delete_duplicates(head));
    }

    #[test]
    fn merge() {
        let nums1 = &mut vec![1, 2, 3, 0, 0, 0];
        let excepted = vec![1, 2, 2, 3, 5, 6];
        super::merge(nums1, 3, &mut vec![2, 5, 6], 3);
        assert_eq!(excepted, *nums1);
    }

    #[test]
    fn generate_pascal_triangle() {
        assert_eq!(vec![vec![1]], super::generate_pascal_triangle(1));
        assert_eq!(
            vec![vec![1], vec![1, 1]],
            super::generate_pascal_triangle(2)
        );
        assert_eq!(
            vec![vec![1], vec![1, 1], vec![1, 2, 1]],
            super::generate_pascal_triangle(3)
        );
        assert_eq!(
            vec![vec![1], vec![1, 1], vec![1, 2, 1], vec![1, 3, 3, 1]],
            super::generate_pascal_triangle(4)
        );
    }
    #[test]
    fn generate_pascal_triangle_nth_row() {
        assert_eq!(vec![1], super::generate_pascal_triangle_nth_row(0));
        assert_eq!(vec![1, 1], super::generate_pascal_triangle_nth_row(1));
        assert_eq!(vec![1, 2, 1], super::generate_pascal_triangle_nth_row(2));
        assert_eq!(vec![1, 3, 3, 1], super::generate_pascal_triangle_nth_row(3));
    }

    #[test]
    fn convert_to_title() {
        assert_eq!("ZY", super::convert_to_title(701));
        assert_eq!("ZZ", super::convert_to_title(702));
        assert_eq!("AAA", super::convert_to_title(703));
    }

    #[test]
    fn title_to_number() {
        assert_eq!(1, super::title_to_number("A".to_string()));
        assert_eq!(26, super::title_to_number("Z".to_string()));
        assert_eq!(25, super::title_to_number("Y".to_string()));
        assert_eq!(27, super::title_to_number("AA".to_string()));
        assert_eq!(701, super::title_to_number("ZY".to_string()));
        assert_eq!(702, super::title_to_number("ZZ".to_string()));
    }

    #[test]
    fn is_happy() {
        assert_eq!(true, super::is_happy(19));
        assert_eq!(false, super::is_happy(4));
    }

    #[test]
    fn add_digits() {
        assert_eq!(2, super::add_digits(38));
        assert_eq!(0, super::add_digits(0));
        assert_eq!(2, super::add_digits2(38));
        assert_eq!(0, super::add_digits(0));
    }

    #[test]
    fn is_ugly() {
        assert_eq!(false, super::is_ugly(14));
        assert_eq!(false, super::is_ugly(11));
        assert_eq!(false, super::is_ugly(-11));
        assert_eq!(true, super::is_ugly(6));
    }

    #[test]
    fn missing_number() {
        assert_eq!(2, super::missing_number(vec![3, 0, 1]));
        assert_eq!(8, super::missing_number(vec![9, 6, 4, 2, 3, 5, 7, 0, 1]));
    }

    #[test]
    fn power_of_three() {
        assert_eq!(false, super::is_power_of_three(-1));
        assert_eq!(true, super::is_power_of_three(1));
        assert_eq!(true, super::is_power_of_three(3));
        assert_eq!(true, super::is_power_of_three(27));
    }

    #[test]
    fn power_of_four() {
        assert_eq!(false, super::is_power_of_four(-1));
        assert_eq!(true, super::is_power_of_four(1));
        assert_eq!(true, super::is_power_of_four(4));
        assert_eq!(true, super::is_power_of_four(64));
    }

    #[test]
    fn perfect_square_number() {
        assert_eq!(true, is_perfect_square(4));
        assert_eq!(true, is_perfect_square(16));
        assert_eq!(false, is_perfect_square(8));
    }

    #[test]
    fn to_hex() {
        assert_eq!("13".to_string(), super::to_hex(19));
        assert_eq!("ffffffff".to_string(), super::to_hex(-1));
    }

    #[test]
    fn fizz_buzz() {
        assert_eq!(vec!["1".to_string()], super::fizz_buzz(1));
    }

    #[test]
    fn add_strings() {
        assert_eq!(
            "135".to_string(),
            super::add_strings("12".to_string(), "123".to_string())
        );
        assert_eq!(
            "134".to_string(),
            super::add_strings("11".to_string(), "123".to_string())
        );
        assert_eq!(
            "533".to_string(),
            super::add_strings("456".to_string(), "77".to_string())
        );
        assert_eq!(
            "10".to_string(),
            super::add_strings("1".to_string(), "9".to_string())
        );
        assert_eq!(
            "413".to_string(),
            super::add_strings("408".to_string(), "5".to_string())
        );
    }

    #[test]
    fn arrange_coins() {
        assert_eq!(1, super::arrange_coins(1));
        assert_eq!(2, super::arrange_coins(5));
        assert_eq!(3, super::arrange_coins(8));
        assert_eq!(2, super::arrange_coins(3));
    }

    #[test]
    fn construct_rectangle() {
        assert_eq!(vec![2, 2], super::construct_rectangle(4));
        assert_eq!(vec![37, 1], super::construct_rectangle(37));
        assert_eq!(vec![427, 286], super::construct_rectangle(122122));
    }

    #[test]
    fn convert_to_base7() {
        assert_eq!("10".to_string(), super::convert_to_base7(7));
        assert_eq!("202".to_string(), super::convert_to_base7(100));
        assert_eq!("-10".to_string(), super::convert_to_base7(-7));
    }

    #[test]
    fn check_perfect_number() {
        assert_eq!(false, super::check_perfect_number(7));
        assert_eq!(true, super::check_perfect_number(28));
    }

    #[test]
    fn fib() {
        assert_eq!(1, super::fib(1));
        assert_eq!(1, super::fib(2));
        assert_eq!(2, super::fib(3));
        assert_eq!(3, super::fib(4));
        assert_eq!(5, super::fib(5));
    }

    #[test]
    fn maximum_product() {
        assert_eq!(6, super::maximum_product(vec![1, 2, 3]));
        assert_eq!(24, super::maximum_product(vec![1, 2, 3, 4]));
        assert_eq!(-6, super::maximum_product(vec![-1, -2, -3]));
    }

    #[test]
    fn self_dividing_numbers() {
        assert_eq!(
            vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22],
            super::self_dividing_numbers(1, 22)
        );
        assert_eq!(vec![48, 55, 66, 77], super::self_dividing_numbers(47, 85));
    }

    #[test]
    fn count_prime_set_bits() {
        assert_eq!(5, super::count_prime_set_bits(10, 15));
        assert_eq!(4, super::count_prime_set_bits(6, 10));
    }

    #[test]
    fn max_count() {
        assert_eq!(4, super::max_count(3, 3, vec![vec![2, 2, ], vec![3, 3]]))
    }

    #[test]
    fn largest_triangle_area() {
        assert_eq!(
            2.0,
            super::largest_triangle_area(vec![
                vec![0, 0],
                vec![0, 1],
                vec![1, 0],
                vec![0, 2],
                vec![2, 0]
            ])
        )
    }

    #[test]
    fn is_rectangle_overlap() {
        assert_eq!(
            true,
            super::is_rectangle_overlap(vec![0, 0, 2, 2], vec![1, 1, 3, 3])
        );
    }
    #[test]
    fn smallest_range_i() {
        assert_eq!(0, super::smallest_range_i(vec![1], 0));
        assert_eq!(6, super::smallest_range_i(vec![0, 10], 2));
    }

    #[test]
    fn has_groups_size_x() {
        assert_eq!(false, super::has_groups_size_x(vec![1]));
        assert_eq!(true, super::has_groups_size_x(vec![1, 1, 2, 2, 3, 3]));
    }

    #[test]
    fn max_sub_array_sum() {
        assert_eq!(22, super::max_sub_array_sum(vec![1, 3, -12, 4, 5, 13]));
    }

    #[test]
    fn largest_perimeter() {
        assert_eq!(5, super::largest_perimeter(vec![2, 2, 1]));
        assert_eq!(0, super::largest_perimeter(vec![2, 1, 1]));
    }

    #[test]
    fn duplicate_zeros() {
        let mut l = vec![1, 0, 2, 3, 0, 4, 5, 0];
        super::duplicate_zeros(&mut l);
        assert_eq!(vec![1, 0, 0, 2, 3, 0, 0, 4], l);
    }

    #[test]
    fn check_if_exists() {
        assert_eq!(true, super::check_if_exist(vec![10, 2, 5, 3]))
    }

    #[test]
    fn add_to_array_form() {
        assert_eq!(super::add_to_array_form(vec![0], 24), vec![2, 4])
    }

    #[test]
    fn sort_colors() {
        let mut input = vec![0, 1, 2, 0, 2, 1];
        super::sort_colors(&mut input);
        assert_eq!(vec![0, 0, 1, 1, 2, 2], input);
    }

    #[test]
    fn distribute_candies() {
        assert_eq!(vec![5, 2, 3], super::distribute_candies(10, 3));
    }

    #[test]
    fn string_matching() {
        assert_eq!(
            vec![String::from("as"), String::from("hero")],
            super::string_matching(vec![
                "mass".to_string(),
                "as".to_string(),
                "hero".to_string(),
                "superhero".to_string()
            ])
        )
    }

    #[test]
    fn min_inc() {
        //assert_eq!(6, min_increment_for_unique(vec![3, 2, 1, 2, 1, 7]))
    }
}
