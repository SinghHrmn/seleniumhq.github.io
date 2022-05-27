# frozen_string_literal: true

require 'spec_helper'

RSpec.describe 'Pen' do
  it 'uses a pen' do
    @driver.get 'https://www.selenium.dev/selenium/web/pointerActionsPage.html'
    start = Time.now

    rect = @driver.find_element(id: 'pointerArea').rect
    actions = @driver.action
    actions.add_pointer_input(:pen, 'default pen')
    actions.default_move_duration = 0.8
    actions.move_by(rect.x + 5, rect.y + 5, device: 'default pen')
           .pointer_down(:left, device: 'default pen')
           .move_by(2, 2, device: 'default pen')
           .pointer_up(:left, device: 'default pen')
    actions.perform

    expect(Time.now - start).to be > 1.6

    moves = @driver.find_elements(class: 'pointermove')
    move_to = properties(moves[0])
    down = properties(@driver.find_element(class: 'pointerdown'))
    move_by = properties(moves[1])
    up = properties(@driver.find_element(class: 'pointerup'))

    expect(move_to).to include("button" => "-1",
                               "pageX" => (rect.x + 5).to_s,
                               "pageY" => (rect.y + 5).floor.to_s)
    expect(down).to include("button" => "0",
                            "pageX" => (rect.x + 5).to_s,
                            "pageY" => (rect.y + 5).floor.to_s)
    expect(move_by).to include("button" => "-1",
                               "pageX" => (rect.x + 5 + 2).to_s,
                               "pageY" => (rect.y + 5 + 2).floor.to_s)
    expect(up).to include("button" => "0",
                          "pageX" => (rect.x + 5 + 2).to_s,
                          "pageY" => (rect.y + 5 + 2).floor.to_s)
  end

  def properties(element)
    element.text.sub(/.*?\s/, '').split(',').map { |item| item.lstrip.split /\s*:\s*/ }.to_h
  end
end
