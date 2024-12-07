use std::collections::HashMap;

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
            println!("total: {}, prev: {}", total, pre);
            pre = int_val;
        } else {
            total = total + int_val;
            println!("total: {}, prev: {}", total, pre);
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
    let mid = 0;
    while first < last {
        let mid = first + (last - first) / 2;
        println!("f:{},l:{},m:{}", first, last, mid);
        if nums[mid] == target {
            return mid as i32;
        } else if nums[mid] < target {
            first = mid + 1;
        } else {
            last = mid;
        }
    }
    println!("{},{},{}", first, last, mid);
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
