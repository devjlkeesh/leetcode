use std::cmp::Reverse;
use std::collections::BinaryHeap;
use crate::medium::ListNode;

mod easy;
mod medium;

fn main() {
    let head = ListNode::build_from(vec![1, 0,1,0]);
   let m =  easy::get_decimal_value(head);
    println!("{}", m);
    let mut pq = BinaryHeap::new();
    pq.push(Reverse(2));
    pq.push(Reverse(1));
    pq.push(Reverse(0));
    pq.push(Reverse(12));
    while let Some(Reverse(p)) = pq.pop() {
        println!("p={}", p);
    }
    println!("calc result = {}",medium::calculate("3+2*2".to_string()))
}
