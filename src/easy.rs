use std::collections::{HashMap, HashSet};
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

#[cfg(test)]
mod tests {
    use super::*;
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
    fn count_prime_set_bits(){
        assert_eq!(5,super::count_prime_set_bits(10,15));
        assert_eq!(4,super::count_prime_set_bits(6,10));
    }

}
