use crate::medium::ListNode;

mod easy;
mod medium;

fn main() {
    let head = ListNode::build_from(vec![1, 0,1,0]);
   let m =  easy::get_decimal_value(head);
    println!("{}", m);
}
