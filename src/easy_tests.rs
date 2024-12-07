use crate::easy;
#[test]
fn two_sum() {
    assert_eq!(easy::two_sum(vec![2, 7, 11, 15], 9), vec![0, 1]);
    assert_eq!(easy::two_sum(vec![3, 2, 4], 6), vec![1, 2]);
}

#[test]
fn palindrome() {
    assert_eq!(easy::palindrome(121), true);
    assert_eq!(easy::palindrome(12), false);
    assert_eq!(easy::palindrome(-12), false);
}

#[test]
fn roman_to_int() {
    assert_eq!(easy::roman_to_int(String::from("III")), 3);
    assert_eq!(easy::roman_to_int(String::from("IV")), 4);
    assert_eq!(easy::roman_to_int(String::from("IX")), 9);
    assert_eq!(easy::roman_to_int(String::from("LVIII")), 58);
    assert_eq!(easy::roman_to_int(String::from("MCMXCIV")), 1994);
    assert_eq!(easy::roman_to_int(String::from("MCMXCV")), 1995);
}

#[test]
fn longest_common_prefix() {
    assert_eq!(
        easy::longest_common_prefix(vec![String::from("")]),
        String::from("")
    );
    assert_eq!(
        easy::longest_common_prefix(vec![String::from("III"), String::from("I")]),
        String::from("I")
    );
}

#[test]
fn is_valid_parentheses() {
    assert_eq!(easy::is_valid_parentheses(String::from("")), false);
    assert_eq!(easy::is_valid_parentheses(String::from("{}")), true);
    assert_eq!(easy::is_valid_parentheses(String::from("()[]{}")), true);
    assert_eq!(easy::is_valid_parentheses(String::from("()[]}")), false);
    assert_eq!(easy::is_valid_parentheses(String::from("(]")), false);
    assert_eq!(easy::is_valid_parentheses(String::from("({[)")), false);
}

#[test]
fn remove_duplicates() {
    assert_eq!(easy::remove_duplicates(&mut vec![0, 0, 1, 2, 3, 4]), 5)
}

fn create_list(values: Vec<i32>) -> Option<Box<easy::ListNode>> {
    let mut head = None;
    for &val in values.iter().rev() {
        let mut new_node = easy::ListNode::new(val);
        new_node.next = head;
        head = Some(Box::new(new_node));
    }
    head
}

#[test]
fn test_merge_two_sorted_lists_both_non_empty() {
    let list1 = create_list(vec![1, 3, 5]);
    let list2 = create_list(vec![2, 4, 6]);
    let result = easy::merge_two_lists(list1, list2);
    let expected = create_list(vec![1, 2, 3, 4, 5, 6]);

    assert_eq!(result, expected);
}

#[test]
fn test_merge_two_sorted_lists_one_empty() {
    let list1 = create_list(vec![1, 2, 3]);
    let list2: Option<Box<easy::ListNode>> = None;
    let result = easy::merge_two_lists(list1, list2);
    let expected = create_list(vec![1, 2, 3]);

    assert_eq!(result, expected);
}

#[test]
fn test_merge_two_sorted_lists_both_empty() {
    let list1: Option<Box<easy::ListNode>> = None;
    let list2: Option<Box<easy::ListNode>> = None;
    let result = easy::merge_two_lists(list1, list2);
    let expected: Option<Box<easy::ListNode>> = None;

    assert_eq!(result, expected);
}

#[test]
fn test_merge_two_sorted_lists_with_duplicates() {
    let list1 = create_list(vec![1, 2, 4]);
    let list2 = create_list(vec![1, 3, 4]);
    let result = easy::merge_two_lists(list1, list2);
    let expected = create_list(vec![1, 1, 2, 3, 4, 4]);

    assert_eq!(result, expected);
}

#[test]
fn test_remove_element() {
    assert_eq!(easy::remove_element(&mut vec![1, 2, 1, 2], 2), 2)
}

#[test]
fn test_str_str() {
    assert_eq!(
        easy::str_str(String::from("saddffsad"), String::from("sad")),
        0
    );
    assert_eq!(
        easy::str_str(String::from("saddffsad"), String::from("sada")),
        -1
    );
    assert_eq!(easy::str_str(String::from("a"), String::from("a")), 0);
}

#[test]
fn test_search_insert() {
    assert_eq!(easy::search_insert(vec![1, 2, 3, 4, 5, 6, 7, 8, 9], 3), 2);
    assert_eq!(easy::search_insert(vec![-32, 1, 12, 82], -32), 0);
    assert_eq!(easy::search_insert(vec![1, 3, 5, 6], 2), 1);
    assert_eq!(easy::search_insert(vec![3, 5, 6], 2), 0);
    assert_eq!(easy::search_insert(vec![3, 5, 6], 4), 1);
    assert_eq!(easy::search_insert(vec![3, 5, 7], 6), 2);
}

#[test]
fn test_length_of_last_word() {
    assert_eq!(easy::length_of_last_word(String::from("")), 0);
    assert_eq!(easy::length_of_last_word(String::from("Hello World ")), 5);
}

#[test]
fn test_plus_one() {
    assert_eq!(easy::plus_one(vec![1, 2, 3]), vec![1, 2, 4]);
    assert_eq!(easy::plus_one(vec![8]), vec![9]);
    assert_eq!(easy::plus_one(vec![9]), vec![1, 0]);
}
